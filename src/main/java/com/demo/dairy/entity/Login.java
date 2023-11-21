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
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loginId;
	@NotNull(message = "Cannot be null")
	private String userName;
	@NotNull(message = "Cannot be null")
	private String password;
	@NotNull(message = "Cannot be null")
	private String userRole;

}
