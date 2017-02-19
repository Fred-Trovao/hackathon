package br.com.thesharks.hackathon.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thesharks.hackathon.persist.entity.Interesse;
import br.com.thesharks.hackathon.persist.entity.Usuario;
import br.com.thesharks.hackathon.security.SecurityUtils;

@Service
public class InteresseService extends GenericService<Interesse> {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	@Transactional
	public Interesse incluir(Interesse interesse) {

		interesse.setUsuario(usuarioService.findByLogin(SecurityUtils.getCurrentLogin()));

		return super.incluir(interesse);
	}

	public List<Interesse> listarInteresses() {

		Usuario usuario = usuarioService.getUsuarioCurrent();

		return null;
	}
}
