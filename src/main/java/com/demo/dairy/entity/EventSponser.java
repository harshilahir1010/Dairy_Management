package com.demo.dairy.entity;

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
public class EventSponser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sponserId;
	@NotNull
	private String sponserEventName;
	@NotNull
	private String sponserEventDetails;
	@NotNull
	private int sponserEventBudget;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;

}
