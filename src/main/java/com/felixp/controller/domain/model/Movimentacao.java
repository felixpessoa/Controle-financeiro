package com.felixp.controller.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.felixp.controller.domain.model.enums.TipoMovimento;

@Entity
public class Movimentacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIMENTACAO")
	@SequenceGenerator(name = "MOVIMENTACAO", sequenceName = "S_ID_MOVIMENTACAO", allocationSize = 1, initialValue = 100)
	private Integer id;
	
	@ManyToOne
	private Conta conta;
	
	@ManyToOne
	private Cliente cliente;
	private double valor;
	private Integer tipoMovimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data;

	public Movimentacao() {
		super();
	}

	public Movimentacao(Integer id, Conta conta, Cliente cliente, TipoMovimento tipoMovimento, LocalDateTime data,
			double valor) {
		super();
		this.id = id;
		this.tipoMovimento = tipoMovimento.getCod();
		this.data = data;
		this.cliente = cliente;
		this.conta = conta;
		this.setValor(valor);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public TipoMovimento getTipoMovimento() {
		return TipoMovimento.toEnum(tipoMovimento);
	}

	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento.getCod();
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, conta, id, tipoMovimento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(conta, other.conta)
				&& Objects.equals(id, other.id) && Objects.equals(tipoMovimento, other.tipoMovimento);
	}

	
	
	
	

}
