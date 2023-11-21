package com.demo.dairy.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dairy.dto.MessageDtoRequest;
import com.demo.dairy.entity.Message;
import com.demo.dairy.entity.Vendor;
import com.demo.dairy.repo.MessageRepo;
import com.demo.dairy.repo.VendorRepo;
import com.demo.dairy.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageRepo repo;
	
	@Autowired
	private VendorRepo repo2;

	@Override
	public Message sendMessage(MessageDtoRequest request) throws Exception {
		Vendor sender=repo2.findById(request.getSenderId()).get();
		Vendor reciver=repo2.findById(request.getReceiverId()).get();
		
		if(sender == null && reciver == null) {
			throw new Exception("Please enter valid sender and reciver id");
		}
		Message message=new Message();
		message.setSender(sender);
		message.setReceiver(reciver);
		message.setMessage(request.getMessage());
		return repo.save(message);
	}

	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	

}
