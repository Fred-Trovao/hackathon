package br.com.thesharks.hackathon.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thesharks.hackathon.persist.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

}
