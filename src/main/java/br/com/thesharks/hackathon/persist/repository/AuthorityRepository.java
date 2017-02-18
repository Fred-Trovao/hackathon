package br.com.thesharks.hackathon.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thesharks.hackathon.persist.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}