package br.com.thesharks.hackathon.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.thesharks.hackathon.controller.UsuarioController;
import br.com.thesharks.hackathon.exception.EntidadeNaoEncontradaException;
import br.com.thesharks.hackathon.persist.entity.Interesse;
import br.com.thesharks.hackathon.persist.entity.Usuario;
import br.com.thesharks.hackathon.persist.entity.enums.TipoInteresseEnum;
import br.com.thesharks.hackathon.persist.repository.InteresseRepository;
import br.com.thesharks.hackathon.security.SecurityUtils;

@Service
@Transactional(readOnly=true)
public class InteresseService extends GenericService<Interesse> {

	private static final Logger logger = LoggerFactory.getLogger(InteresseService.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private InteresseRepository interesseRepository;

	@Override
	@Transactional
	public Interesse incluir(Interesse interesse) {

		interesse.setUsuario(usuarioService.findByLogin(SecurityUtils.getCurrentLogin()));

		return super.incluir(interesse);
	}
	
	public List<Interesse> listarInteressesParaUsuario(Usuario usuario) {

		Assert.notNull(usuario);

		List<Interesse> interesses = getByUsuario(usuario);
		
		if(interesses == null || interesses.isEmpty()){
			throw new EntidadeNaoEncontradaException("Qual seu interesse? Casdastre-o para que a gente possa lhe ajudar.");
		}
		
		if(interesses.size() > 1){
			logger.warn("A regra de um interesse por usuario foi ferida");
		}
		
		Interesse interesseUsuario = interesses.get(0);
		
		return findByTipoDeInteresseAndValor(interesseUsuario.getTipoInteresse(), interesseUsuario.getValorDoInteresse());
	}
	
	public List<Interesse> findByTipoDeInteresseAndValor(TipoInteresseEnum tipo, BigDecimal valor){
		
		Assert.notNull(tipo);
		Assert.notNull(valor);
		
		switch(tipo) {
		case REPASSE:
			return interesseRepository.findByTipoInteresseAndValorDoInteresseGreaterThanEqual(TipoInteresseEnum.RECEBER, valor);
		case RECEBER:
			return interesseRepository.findByTipoInteresseAndValorDoInteresseLessThanEqual(TipoInteresseEnum.REPASSE, valor);
		default:
			throw new IllegalArgumentException("tipo de interesse não suportado");
		}
	}

	public List<Interesse> getByUsuario(Usuario usuario) {
		
		List<Interesse> interesses = interesseRepository.findByUsuario(usuario);
				
		return interesses;
	}
}
