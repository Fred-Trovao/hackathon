package br.com.thesharks.hackathon.persist.repository;

import org.springframework.stereotype.Repository;

import br.com.thesharks.hackathon.persist.entity.Usuario;

@Repository
public interface UsuarioRepository extends EntidadeRepository<Usuario> {

	Usuario findByLogin(String login);

}
