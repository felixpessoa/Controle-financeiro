package com.felixp.controller.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felixp.controller.domain.model.Cliente;
import com.felixp.controller.domain.model.Conta;
import com.felixp.controller.domain.model.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
	
	List<Movimentacao> findByCliente(Cliente cliente);
	List<Movimentacao> findByConta(Conta conta);
	
	

}
