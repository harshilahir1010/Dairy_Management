package com.demo.dairy.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParlourLoan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long palourLoanId;
	
	@NotNull
	private long vendorId;
	
	@ColumnDefault("0")
	private int loanApproved;
	
	@ColumnDefault("0")
	private int parlourApproved;
	
	

}
