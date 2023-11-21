package com.demo.dairy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dairy.entity.Message;

public interface MessageRepo extends JpaRepository<Message, Long>{

}
