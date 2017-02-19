package br.com.thesharks.hackathon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thesharks.hackathon.persist.entity.Usuario;
import br.com.thesharks.hackathon.persist.repository.UsuarioRepository;
import br.com.thesharks.hackathon.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> usuariosList() {
		logger.debug("get usuarios list");
		return usuarioService.getAll();
	}

	@GetMapping(value = "/{usuarioId}")
	public Usuario getusuario(@PathVariable Long usuarioId) {
		logger.debug("get usuario");
		return usuarioService.findById(usuarioId);
	}

	@PostMapping
	public Usuario saveusuario(@RequestBody Usuario usuario) {
		logger.debug("save usuario");
		usuarioService.salvarOuAtualizar(usuario);
		return usuario;
	}

}
