package com.demo.dairy.service;

import java.util.List;

import com.demo.dairy.dto.MessageDtoRequest;
import com.demo.dairy.entity.Message;

public interface MessageService {

	Message sendMessage(MessageDtoRequest request)throws Exception;

	List<Message> findAll();

}
