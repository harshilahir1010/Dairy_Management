package com.demo.dairy.entity;

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
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long messageId;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "sender_id")
	private Vendor sender;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "receiver_id")
	private Vendor receiver;
	
	@NotNull
	private String message;

}
