package com.felixp.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felixp.controller.domain.model.Cliente;
import com.felixp.controller.domain.model.Endereco;
import com.felixp.controller.domain.model.enums.TipoCliente;
import com.felixp.controller.domain.repository.ClienteRepository;

@SpringBootApplication
public class ControleFinanceiroApplication implements CommandLineRunner{
	
//	@Autowired
//	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ControleFinanceiroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Endereco e1 = new Endereco(null, "Rua Beira rio", "190", "Apartamento 328", "Boa Vista", "Recife", "PE", "50010100");
//		Endereco e2 = new Endereco(null, "Rua da goiaba", "124", "Casa", "Vila do chave", "Recife", "PE", "53421-244");
		
//		Cliente cli1 = new Cliente(null, "Carlos", "(81)9.8787-7878", new Endereco(null, "Rua Beira rio", "190", "Apartamento 328", "Boa Vista", "Recife", "PE", "50010100"), LocalDateTime.of(2021, 10, 20, 12, 30), "13245678910", TipoCliente.PESSOA_PESSOAFISICA);
//		Cliente cli2 = new Cliente(null, "Zefa", "(81)9.8585-2525", new Endereco(null, "Rua da goiaba", "124", "Casa", "Vila do chave", "Recife", "PE", "53421-244"), LocalDateTime.of(2021, 10, 20, 12, 30), "13245678911", TipoCliente.PESSOA_JURIDICA);
//	
//		
//		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		
		
	}

}
