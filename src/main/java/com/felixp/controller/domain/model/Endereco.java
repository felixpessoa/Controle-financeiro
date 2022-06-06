package com.felixp.controller.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "enderecos")
@Data
public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO")
	@SequenceGenerator(name = "ENDERECO", sequenceName = "S_ID_ENDERECO", allocationSize = 1, initialValue = 100)
	private Integer id;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	public Endereco() {
		super();
	}
	
	public Endereco(Integer id, String rua, String numero, String complemento, String bairro, String cidade, String uf,
			String cep) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}



	
	
	
	

}


