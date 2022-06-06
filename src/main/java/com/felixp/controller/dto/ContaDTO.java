package com.felixp.controller.dto;

import java.io.Serializable;

import com.felixp.controller.domain.model.Conta;

public class ContaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private double saldo;
	private Integer cliente;

	public ContaDTO() {
		super();
	}

	public ContaDTO(Conta obj) {
		super();
		this.id = obj.getId();
		this.saldo = obj.getSaldo();
		this.cliente = obj.getCliente().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	
	
	

}
