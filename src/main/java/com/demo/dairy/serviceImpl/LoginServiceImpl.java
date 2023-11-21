package com.demo.dairy.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.dairy.entity.Dairy;
import com.demo.dairy.entity.Login;
import com.demo.dairy.repo.LoginRepo;
import com.demo.dairy.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<Login> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Login> findSpecific(long id) throws Exception {
		Optional<Login> login=repo.findById(id);
		if(login.isPresent()) {
			return login;
		}else {
			throw new Exception("User Not Found by id "+id+" !!!!");
		}
		
	}

	@Override
	public Login save(Login login) {
	    login.setPassword(passwordEncoder.encode(login.getPassword()));
		return repo.save(login);
	}

	@Override
	public Login edit(long id, Login login) {
		Login login2=repo.findById(id).get();
		login2.setPassword(passwordEncoder.encode(login.getPassword()));
		login2.setUserName(login.getUserName());
		login2.setUserRole(login.getUserRole());
		return repo.save(login2);
	}

	@Override
	public String delete(long id) {
		Optional<Login> login=repo.findById(id);
		if(login.isPresent()) {
			Login d=repo.findById(id).get();
			repo.delete(d);
			return "User with "+id+" deleted sucessfully";
		}else {
		return "User with "+id+" not present";
		}
	}

}
