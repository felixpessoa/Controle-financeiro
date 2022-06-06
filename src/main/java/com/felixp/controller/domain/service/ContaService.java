package com.felixp.controller.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.felixp.controller.domain.model.Cliente;
import com.felixp.controller.domain.model.Conta;
import com.felixp.controller.domain.repository.ContaRepository;
import com.felixp.controller.domain.service.exception.DataIntegrityException;
import com.felixp.controller.domain.service.exception.ObjectNotFoundException;
import com.felixp.controller.dto.ContaDTO;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private ClienteService clienteService;

	public Conta create(ContaDTO dto) {
		Conta conta = fromDTO(dto); 
		return contaRepository.save(conta);
	}


	public List<Conta> findAll() {
		return contaRepository.findAll();
	}

	public Conta findById(Integer id) {
		Optional<Conta> obj = contaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Conta.class.getName()));
	}

	public Conta update(Integer id, ContaDTO dto) {
		findById(id);
		dto.setId(id);
		return create(dto);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			contaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma conta que possui cliente");
		}
	}
	
	
	private Conta fromDTO(ContaDTO dto) {
		Conta conta = new Conta();
		conta.setId(dto.getId());
		conta.setSaldo(dto.getSaldo());
		Cliente cliente = clienteService.findById(dto.getCliente());
		conta.setCliente(cliente);
		return conta;
	}
	

}
