package br.upf.gabrielDias.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_ID_SEQ")
	@SequenceGenerator(name = "PRODUTO_ID_SEQ", sequenceName = "PRODUTO_ID_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME")
	private String nome;

	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "QUANTIDADE")
	private Double quantidade;
	
	@Column(name = "PRECO")
	private Double preco;
	
	@Column(name = "TIPO")
	private String tipo;

}
