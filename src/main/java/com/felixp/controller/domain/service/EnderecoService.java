package com.felixp.controller.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.felixp.controller.domain.model.Endereco;
import com.felixp.controller.domain.repository.EnderecoRepository;
import com.felixp.controller.domain.service.exception.DataIntegrityException;
import com.felixp.controller.domain.service.exception.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco create(Endereco endereco) {				
		return enderecoRepository.save(endereco);
	}

	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public Endereco findById(Integer id) {
		Optional<Endereco> obj = enderecoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Endereco.class.getName()));
	}

	public Endereco update(Integer id, Endereco endereco) {
		findById(id);
		endereco.setId(id);
		return create(endereco);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			enderecoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um endereco que possui cliente");
		}
	}

}
