package com.demo.dairy.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.dairy.entity.ParlourLoan;
import com.demo.dairy.entity.Vendor;
import com.demo.dairy.repo.ParlourLoanRepo;
import com.demo.dairy.repo.VendorRepo;
import com.demo.dairy.service.ParlourLoanService;

@Service
public class ParlourLoanServiceImpl implements ParlourLoanService{
	
	@Autowired
	private ParlourLoanRepo repo;
	
	@Autowired
	private VendorRepo repo2;
	

	@Override
	public List<ParlourLoan> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<ParlourLoan> findSpecific(long id) throws Exception {
		Optional<ParlourLoan> parlourLoan=repo.findById(id);
		if(parlourLoan.isPresent()) {
			return parlourLoan;
		}else {
			throw new Exception("Parlour Not Found by id "+id+" !!!!");
		}
		
	}

	@Override
	public ParlourLoan save(ParlourLoan parlourLoan) {
		return repo.save(parlourLoan);
	}

	@Override
	public ParlourLoan edit(long id, ParlourLoan parlourLoan) {
		ParlourLoan parlourLoan2=repo.findById(id).get();
		parlourLoan2.setLoanApproved(parlourLoan.getLoanApproved());
		parlourLoan2.setParlourApproved(parlourLoan.getParlourApproved());
	//	parlourLoan2.setVendor(parlourLoan.getVendor());
		return repo.save(parlourLoan2);
	}

	@Override
	public String delete(long id) {
		Optional<ParlourLoan> parlourLoan=repo.findById(id);
		if(parlourLoan.isPresent()) {
			ParlourLoan d=repo.findById(id).get();
			repo.delete(d);
			return "Palour with "+id+" deleted sucessfully";
		}else {
		return "Palour with "+id+" not present";
		}
	}

	@Override
	public String getApproved(long vendorId) {
		Vendor vendor=repo2.findById(vendorId).get();
		if(vendor!=null && vendor.getVendorExperience()>5) {
	//		ParlourLoan loan=repo.findByVendorId(vendorId);
			ParlourLoan loan=new ParlourLoan();
			loan.setVendorId(vendorId);	
			loan.setLoanApproved(1);
			loan.setPalourLoanId(1);
			repo.save(loan);
			return "Approved loan and parlour";
		}else {
			return "Minimum 5 years of experience required";
		}
		
	}



}
