package com.demo.dairy.service;

import java.util.List;
import java.util.Optional;

import com.demo.dairy.entity.ParlourLoan;

public interface ParlourLoanService {

	List<ParlourLoan> findAll();

	Optional<ParlourLoan> findSpecific(long id) throws Exception;

	ParlourLoan save(ParlourLoan parlourLoan);

	ParlourLoan edit(long id, ParlourLoan parlourLoan);

	String delete(long id);

	String getApproved(long vendorId);

}
