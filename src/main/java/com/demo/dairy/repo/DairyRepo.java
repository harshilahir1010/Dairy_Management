package com.demo.dairy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dairy.entity.Dairy;

public interface DairyRepo extends JpaRepository<Dairy, Long>{

}
