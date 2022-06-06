package com.felixp.controller.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.felixp.controller.domain.model.Movimentacao;
import com.felixp.controller.domain.model.enums.TipoMovimento;


public class MovimentacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer conta;
	private Integer cliente;
	private double valor;
	private Integer tipoMovimento;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime data;

	public MovimentacaoDTO() {
		super();
	}

	public MovimentacaoDTO(Movimentacao obj) {
		super();
		this.id = obj.getId();
		this.conta = obj.getConta().getId();
		this.cliente = obj.getCliente().getId();
		this.tipoMovimento = obj.getTipoMovimento().getCod();
		this.data = obj.getData();
		this.valor = obj.getValor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
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
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
	
	

}
