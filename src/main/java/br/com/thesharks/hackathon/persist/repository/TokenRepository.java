package br.com.thesharks.hackathon.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.thesharks.hackathon.persist.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, String>{

}
