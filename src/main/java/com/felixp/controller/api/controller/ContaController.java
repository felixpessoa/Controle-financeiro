package com.felixp.controller.api.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felixp.controller.domain.model.Conta;
import com.felixp.controller.domain.service.ContaService;
import com.felixp.controller.dto.ContaDTO;

@RestController
@RequestMapping("/api/contas")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	
	@PostMapping
	public ResponseEntity<Conta> create(@RequestBody ContaDTO obj){
		obj = new ContaDTO(contaService.create(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(contaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> findByIdLivro(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(contaService.findById(id)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Conta> update(@PathVariable Integer id, @RequestBody ContaDTO obj){
		return ResponseEntity.ok().body(contaService.update(id, obj));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		contaService.delete(id);
			return ResponseEntity.noContent().build();
	}

}
