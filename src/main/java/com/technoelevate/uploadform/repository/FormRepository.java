package com.technoelevate.uploadform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technoelevate.uploadform.dto.Form;

public interface FormRepository extends JpaRepository<Form, Integer>{

	public Form findByEmail(String email); 
}
