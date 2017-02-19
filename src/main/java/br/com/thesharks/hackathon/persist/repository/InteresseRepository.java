package br.com.thesharks.hackathon.persist.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.thesharks.hackathon.persist.entity.Interesse;
import br.com.thesharks.hackathon.persist.entity.Usuario;

@Repository
public interface InteresseRepository extends EntidadeRepository<Interesse>{

	List<Interesse> findByUsuario(Usuario usuario);

}
