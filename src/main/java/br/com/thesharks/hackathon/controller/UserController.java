package br.com.thesharks.hackathon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.thesharks.hackathon.persist.entity.Usuario;
import br.com.thesharks.hackathon.persist.repository.UsuarioRepository;

@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UsuarioRepository userRepo;

	@GetMapping(value = "/users")
	public List<Usuario> usersList() {
		logger.debug("get users list");
		return userRepo.findAll();
	}

	@GetMapping(value = "/users/{userId}")
	public Usuario getUser(@PathVariable Long userId) {
		logger.debug("get user");
		return userRepo.findOne(userId);
	}

	@PostMapping(value = "/users")
	public Usuario saveUser(@RequestBody Usuario user) {
		logger.debug("save user");
		userRepo.save(user);
		return user;
	}

}
