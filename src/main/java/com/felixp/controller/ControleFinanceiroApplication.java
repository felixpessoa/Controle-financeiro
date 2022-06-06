package com.felixp.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felixp.controller.domain.model.Cliente;
import com.felixp.controller.domain.model.Conta;
import com.felixp.controller.domain.model.Endereco;
import com.felixp.controller.domain.model.Movimentacao;
import com.felixp.controller.domain.model.MovimentoPk;
import com.felixp.controller.domain.model.enums.TipoCliente;
import com.felixp.controller.domain.model.enums.TipoMovimento;
import com.felixp.controller.domain.repository.ClienteRepository;
import com.felixp.controller.domain.repository.ContaRepository;
import com.felixp.controller.domain.repository.EnderecoRepository;
import com.felixp.controller.domain.repository.MovimentacaoRepository;

@SpringBootApplication
public class ControleFinanceiroApplication implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ControleFinanceiroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Endereco e1 = new Endereco(null, "Rua goiaba", "123", "CASA", "São jose", "Recife", "PE", "50010100");
		Endereco e2 = new Endereco(null, "Rua goiaba", "123", "CASA", "São jose", "Recife", "PE", "50010100");
		
		Cliente cl1 = new Cliente(null, "Josefa", "81982522552", e1, LocalDateTime.of(2020, 9, 7, 12, 32), "12345678910", TipoCliente.PESSOA_FISICA);
		Cliente cl2 = new Cliente(null, "Mario", "81995958484", e1, LocalDateTime.of(2021, 12, 21, 9, 10), "04657258000116", TipoCliente.PESSOA_JURIDICA);
		
		Conta c1 = new Conta(null, 500, cl1);
		Conta c2 = new Conta(null, 500, cl2);
		Conta c3 = new Conta(null, 1202, cl2);
		
		cl1.getContas().addAll(Arrays.asList(c1));
		cl2.getContas().addAll(Arrays.asList(c2, c3));
		
		Movimentacao m1 = new Movimentacao(null, c1, cl1, TipoMovimento.PAGAMENTO, LocalDateTime.of(2020, 9, 7, 12, 32), 300);
		Movimentacao m2 = new Movimentacao(null, c2, cl2, TipoMovimento.PAGAMENTO, LocalDateTime.of(2021, 12, 21, 9, 10), 200);
		Movimentacao m3 = new Movimentacao(null, c3, cl2, TipoMovimento.RECEBIMENTO, LocalDateTime.of(2022, 2, 20, 13, 17), 1245);
		
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		clienteRepository.saveAll(Arrays.asList(cl1, cl2));
		contaRepository.saveAll(Arrays.asList(c1, c2, c3));
		movimentacaoRepository.saveAll(Arrays.asList(m1, m2, m3));
		
		
		
	}

}
