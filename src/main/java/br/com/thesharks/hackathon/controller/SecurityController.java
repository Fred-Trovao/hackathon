package br.com.thesharks.hackathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thesharks.hackathon.persist.entity.Token;
import br.com.thesharks.hackathon.persist.entity.Usuario;
import br.com.thesharks.hackathon.persist.repository.TokenRepository;
import br.com.thesharks.hackathon.persist.repository.UsuarioRepository;
import br.com.thesharks.hackathon.security.SecurityUtils;

@RestController
@RequestMapping("/security")
public class SecurityController {

	@Autowired
	private UsuarioRepository userRepo;

	@Autowired
	private TokenRepository tokenRepo;

	@GetMapping(value = "/account")
	public Usuario getUserAccount() {
		Usuario user = userRepo.findByLogin(SecurityUtils.getCurrentLogin());
		
		return user;
	}

	@PreAuthorize("hasAuthority('admin')")
	@GetMapping(value = "/tokens")
	public List<Token> getTokens() {
		List<Token> tokens = tokenRepo.findAll();
		for (Token t : tokens) {
			t.setSeries(null);
			t.setValue(null);
		}
		return tokens;
	}

}
