package br.com.thesharks.hackathon.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thesharks.hackathon.persist.entity.Token;

public interface TokenRepository extends JpaRepository<Token, String> {
}
