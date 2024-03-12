package com.full.app.Repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.full.app.Modeles.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);


}
