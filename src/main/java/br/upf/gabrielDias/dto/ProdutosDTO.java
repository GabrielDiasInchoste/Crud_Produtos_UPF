package br.upf.gabrielDias.dto;

import lombok.Data;

@Data
public class ProdutosDTO {

	private Integer id;
	private String nome;
	private String descricao;
	private Double quantidade;
	private String tipo;
	
	
}
