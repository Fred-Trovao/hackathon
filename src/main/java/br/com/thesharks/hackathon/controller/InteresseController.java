package br.com.thesharks.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thesharks.hackathon.persist.entity.Interesse;
import br.com.thesharks.hackathon.persist.entity.Usuario;
import br.com.thesharks.hackathon.security.SecurityUtils;
import br.com.thesharks.hackathon.service.InteresseService;
import br.com.thesharks.hackathon.service.UsuarioService;

@RestController
@RequestMapping("/interesses")
public class InteresseController {

	@Autowired
	private InteresseService interesseService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/salvarInteresse")
	public Interesse incluir(@RequestBody Interesse interesse) {
		Usuario usuario = usuarioService.findByLogin(SecurityUtils.getCurrentLogin());
		interesse.setUsuario(usuario);
		return interesseService.incluir(interesse);
	}
}
