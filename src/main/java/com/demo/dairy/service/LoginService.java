package com.demo.dairy.service;

import java.util.List;
import java.util.Optional;

import com.demo.dairy.entity.Login;

public interface LoginService {
	
    List<Login> findAll();
	
	Optional<Login> findSpecific(long id) throws Exception;
	
	Login save(Login login);
	
	Login edit(long id,Login login);
	
	String delete(long id);

}
