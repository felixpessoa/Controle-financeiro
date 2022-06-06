package com.felixp.controller.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felixp.controller.domain.model.Endereco;
import com.felixp.controller.domain.service.EnderecoService;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	
	@PostMapping
	public ResponseEntity<Endereco> create(@RequestBody Endereco endereco){
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.create(endereco));
	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> findByIdLivro(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findById(id)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Integer id, @RequestBody Endereco endereco){
		return ResponseEntity.ok().body(enderecoService.update(id,endereco));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		enderecoService.delete(id);
			return ResponseEntity.noContent().build();
	}

}
