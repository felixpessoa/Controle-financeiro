package com.felixp.controller.domain.model.enums;

import lombok.Getter;

@Getter
public enum TipoMovimento {
	
	PAGAMENTO(0, "Pagamento"),
	RECEBIMENTO(1, "Recebimento");
	
	private int cod;
	private String descricao;
	
	private TipoMovimento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static TipoMovimento toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoMovimento x : TipoMovimento.values()) {
			if (cod.equals(x.getCod())) { 
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+ cod);
		
	}

}
