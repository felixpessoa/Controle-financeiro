package com.felixp.controller.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.felixp.controller.domain.model.Cliente;
import com.felixp.controller.domain.repository.ClienteRepository;
import com.felixp.controller.domain.service.exception.DataIntegrityException;
import com.felixp.controller.domain.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente create(Cliente cliente) {
		Optional<Cliente> optCliente = clienteRepository.findByCpfOuCnpj(cliente.getCpfOuCnpj());
		if (optCliente.isPresent()) {
			if(!optCliente.get().getId().equals(cliente.getId()))
			throw new ObjectNotFoundException("Já cadastrado!");
		}
		if(cliente.getId()==null) {
			cliente.setDataCriacao(LocalDateTime.now());
		}else {
			cliente.setEndereco(optCliente.get().getEndereco());
			cliente.setDataCriacao(optCliente.get().getDataCriacao());
		}
		
		
		return clienteRepository.save(cliente);
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Cliente.class.getName()));
	}

	public Cliente update(Integer id, Cliente cliente) {
		findById(id);
		cliente.setId(id);
		
		return create(cliente);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível!");
		}
	}

}
