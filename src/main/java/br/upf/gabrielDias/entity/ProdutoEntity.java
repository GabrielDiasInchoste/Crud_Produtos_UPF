package br.upf.gabrielDias.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProdutoEntity {

	@Id
	@Column(name = "ID")
	@NotNull(message = "Id nao informado")
	private Integer id;

	@Column(name = "NOME")
	@NotBlank(message = "Nome nao informado")
	private String nome;

	@Column(name = "DESCRICAO")
	@NotBlank(message = "Descricao nao informada")
	private String descricao;

	@Column(name = "QUANTIDADE")
	@NotNull(message = "Quantidade nao informado")
	private Double quantidade;

	@Column(name = "PRECO")
	@NotNull(message = "Preco nao informado")
	private Double preco;

	@Column(name = "TIPO")
	@NotBlank(message = "Tipo nao informado")
	private String tipo;

}
