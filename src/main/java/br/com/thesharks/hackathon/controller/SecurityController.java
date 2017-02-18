package br.com.thesharks.hackathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.thesharks.hackathon.persist.entity.Token;
import br.com.thesharks.hackathon.persist.entity.User;
import br.com.thesharks.hackathon.persist.repository.TokenRepository;
import br.com.thesharks.hackathon.persist.repository.UserRepository;
import br.com.thesharks.hackathon.security.SecurityUtils;

@RestController
public class SecurityController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TokenRepository tokenRepo;

    @RequestMapping(value = "/security/account", method = RequestMethod.GET)
    public @ResponseBody User getUserAccount() {
	User user = userRepo.findByLogin(SecurityUtils.getCurrentLogin());
	user.setPassword(null);
	return user;
    }

    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping(value = "/security/tokens", method = RequestMethod.GET)
    public @ResponseBody List<Token> getTokens() {
	List<Token> tokens = tokenRepo.findAll();
	for (Token t : tokens) {
	    t.setSeries(null);
	    t.setValue(null);
	}
	return tokens;
    }

}
