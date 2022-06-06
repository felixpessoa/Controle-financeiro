package com.felixp.controller.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felixp.controller.domain.model.Endereco;
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	
	

}
