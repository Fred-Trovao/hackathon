package br.com.thesharks.hanckathon.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thesharks.hanckathon.persist.entity.Authority;

public interface AuthorityRepo extends JpaRepository<Authority, Long> {

}