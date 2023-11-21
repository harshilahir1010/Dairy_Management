package com.demo.dairy.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dairy.entity.ImageData;

public interface ImageDataRepo extends JpaRepository<ImageData, Long>{
	
	Optional<ImageData> findByName(String name);

}
