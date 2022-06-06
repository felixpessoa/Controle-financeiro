package com.felixp.controller.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "contas")
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTA")
	@SequenceGenerator(name = "CONTA", sequenceName = "S_ID_CONTA", allocationSize = 1, initialValue = 100)
	private Integer id;
	private double saldo;
	
	@JsonIgnore
	@ManyToOne
	private Cliente cliente;
	
	public Conta() {
		super();
	}
	
	public Conta(Integer id, double saldo, Cliente cliente) {
		super();
		this.id = id;
		this.saldo = saldo;
		this.cliente = cliente;
	}
	
	public void sacar(double valor) {
		saldo -= valor;
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	


}
