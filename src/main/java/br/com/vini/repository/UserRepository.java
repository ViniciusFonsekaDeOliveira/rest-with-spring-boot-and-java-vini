package br.com.vini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vini.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
