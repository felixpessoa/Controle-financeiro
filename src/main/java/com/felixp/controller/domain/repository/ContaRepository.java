package com.felixp.controller.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felixp.controller.domain.model.Conta;
@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{
	
	

}
