package com.demo.dairy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vendorId;
	
	@NotNull
	private String vendorName;
	@NotNull
	private String vendorPassword;
	@NotNull
	private String vendorLocation;
	@NotNull
	private int vendorExperience;
	@NotNull
	private String vendorContact;
	@NotNull
	private int vendorChargeLocation;

}
