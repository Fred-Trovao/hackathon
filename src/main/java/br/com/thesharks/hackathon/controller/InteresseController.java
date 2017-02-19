package br.com.thesharks.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thesharks.hackathon.persist.entity.Interesse;
import br.com.thesharks.hackathon.service.InteresseService;

@RestController
@RequestMapping("/interesses")
public class InteresseController {

	@Autowired
	private InteresseService interesseService;
	
	@PostMapping
	public Interesse incluir(@RequestBody Interesse interesse) {
		System.out.println("oi");
				return null;
				
//		interesseService.incluir(interesse);
//		return interesse;
	}
}
