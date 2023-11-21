package com.demo.dairy.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	
	@NotNull
	private String customerName;
	//private String customerPassword;
	@NotNull
	private String customerContact;
	@NotNull
	private int customerRatings;
	@NotNull
	private String customerFeedback;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;
	
}
