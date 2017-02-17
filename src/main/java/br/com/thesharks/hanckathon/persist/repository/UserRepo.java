package br.com.thesharks.hanckathon.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thesharks.hanckathon.persist.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByLogin(String login);

}
