package com.felixp.controller.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felixp.controller.domain.model.Cliente;
import com.felixp.controller.domain.model.Conta;
import com.felixp.controller.domain.model.Movimentacao;
import com.felixp.controller.domain.model.enums.TipoCliente;
import com.felixp.controller.domain.model.enums.TipoMovimento;
import com.felixp.controller.domain.repository.MovimentacaoRepository;
import com.felixp.controller.domain.service.exception.ObjectNotFoundException;
import com.felixp.controller.dto.ContaDTO;
import com.felixp.controller.dto.MovimentacaoDTO;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private ContaService contaService;
	@Autowired
	private ClienteService clienteService;
	
	
	public Movimentacao create(MovimentacaoDTO obj) {
		Movimentacao movimentacao = fromDTO(obj);
		if (movimentacao.getId() == null) {
			movimentacao.setData(LocalDateTime.now());
		}
		if(movimentacao.getValor() <= 0) {
			throw new ObjectNotFoundException("Digite um Valor.");
		}
		if ( movimentacao.getTipoMovimento().equals(TipoMovimento.PAGAMENTO)){
			Conta conta = contaService.findById(movimentacao.getConta().getId());
			if(movimentacao.getValor()> conta.getSaldo()) {
				throw new ObjectNotFoundException("Saldo insuficiente.");
			}
			conta.sacar(movimentacao.getValor());
			ContaDTO dto = new ContaDTO(conta);
			contaService.update(conta.getId(), dto);
		}
		if ( movimentacao.getTipoMovimento().equals(TipoMovimento.RECEBIMENTO)){
			Conta conta = contaService.findById(movimentacao.getConta().getId());
			conta.depositar(movimentacao.getValor());
			ContaDTO dto = new ContaDTO(conta);
			contaService.update(conta.getId(), dto);
		}
		if (movimentacao.getId()==null) {
			movimentacao.setData(LocalDateTime.now());
		}
		return movimentacaoRepository.save(movimentacao);
	}
	

	public List<Movimentacao> findAll() {
		return movimentacaoRepository.findAll();
	}
	
	
	public Movimentacao findById(Integer id) {
		Optional<Movimentacao> obj = movimentacaoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Movimentacao.class.getName()));
	}
	
	public Movimentacao update(Integer id, MovimentacaoDTO obj) {
		Movimentacao mov = findById(id);
		obj.setId(id);
		obj.setData(mov.getData());
		return create(obj);
	}

	
	
	
	
	
	private Movimentacao fromDTO(MovimentacaoDTO obj) {
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setId(obj.getId());
		Conta conta = contaService.findById(obj.getConta());
		movimentacao.setConta(conta);
		Cliente cliente = clienteService.findById(obj.getCliente()); 
		movimentacao.setCliente(cliente);
		movimentacao.setTipoMovimento(obj.getTipoMovimento());
		movimentacao.setData(obj.getData());
		movimentacao.setValor(obj.getValor());
		return movimentacao;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
