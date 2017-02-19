package br.com.thesharks.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thesharks.hackathon.persist.entity.Interesse;
import br.com.thesharks.hackathon.persist.entity.Usuario;
import br.com.thesharks.hackathon.persist.repository.InteresseRepository;
import br.com.thesharks.hackathon.security.SecurityUtils;

@Service
@Transactional(readOnly=true)
public class InteresseService extends GenericService<Interesse> {

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

	public List<Interesse> listarInteresses() {

		Usuario usuario = usuarioService.getUsuarioCurrent();

		List<Interesse> interesse = getByUsuario(usuario);
		
		return null;
	}

	public List<Interesse> getByUsuario(Usuario usuario) {
		
		List<Interesse> interesses = interesseRepository.findByUsuario(usuario);
				
		return interesses;
	}
}
