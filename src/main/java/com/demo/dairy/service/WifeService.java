package com.demo.dairy.service;

import java.util.List;
import java.util.Optional;

import com.demo.dairy.entity.Wife;

public interface WifeService {

	List<Wife> findAll();

	Optional<Wife> findSpecific(long id) throws Exception;

	Wife save(Wife wife);

	Wife edit(long id, Wife wife);

	String delete(long id);

}
