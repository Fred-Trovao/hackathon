package br.com.thesharks.hackathon.persist.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.thesharks.hackathon.persist.entity.EntidadeAbstrata;

@NoRepositoryBean
public interface EntidadeRepository<T extends EntidadeAbstrata> extends JpaRepository<T, Serializable> {
}
