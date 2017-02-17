package br.com.thesharks.hanckathon.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thesharks.hanckathon.persist.entity.Token;

public interface TokenRepo extends JpaRepository<Token, String> {
}
