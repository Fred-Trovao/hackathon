package br.com.thesharks.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thesharks.hackathon.persist.entity.Usuario;
import br.com.thesharks.hackathon.persist.repository.UsuarioRepository;
import br.com.thesharks.hackathon.security.SecurityUtils;

@Service
public class UsuarioService extends GenericService<Usuario> {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findByLogin(String currentLogin) {
		return usuarioRepository.findByLogin(currentLogin);
	}

	public Usuario getUsuarioCurrent() {

		Usuario usuario = usuarioRepository.findByLogin(SecurityUtils.getCurrentLogin());

		return usuario;
	}

}
