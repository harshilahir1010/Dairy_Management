package com.demo.dairy.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dairy.entity.Login;

public interface LoginRepo extends JpaRepository<Login, Long>{
	
	Optional<Login> findByUserName(String username);

}
