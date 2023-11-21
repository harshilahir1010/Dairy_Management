package com.demo.dairy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDtoRequest {
	
	@NotNull
	private Long senderId;
	@NotNull
    private Long receiverId;
	@NotBlank
	@Size(min = 10,max = 50)
    private String message;

}
