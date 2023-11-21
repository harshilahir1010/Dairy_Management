package com.demo.dairy.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
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
public class Dairy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dairyId;
	
	
	@Column(name = "dairy_name")
	@NotNull
	private String dairyName;
	
	@Column(name = "dairy_address")
	@NotNull
	private String dairyAddress;
	
	@Column(name = "dairy_password")
	@NotNull
	private String dairyPassword;
	
	@Column(name = "dairy_contact")
	@NotNull
	private String dairyContact;
	
	@Column(name = "dairy_description")
	@NotNull
	private String dairyDescription;
	
	@Column(name = "dairy_ratings")
	@NotNull
	private long dairyRatings;
	
	
}
