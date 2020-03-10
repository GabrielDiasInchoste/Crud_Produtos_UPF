package br.upf.gabrielDias.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.upf.gabrielDias.entity.ProdutoEntity;
import br.upf.gabrielDias.services.ProdutosService;

public class ProdutosController {

	@Autowired
	private ProdutosService produtosService;

	@GetMapping(value = "v1/produtos/{produtoId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoEntity> getProduto(@PathVariable(value = "produtoId") Integer produtoId) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(produtosService.getProduto(produtoId));
	}

	@PostMapping(value = "v1/produtos/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoEntity> postProduto(@RequestBody @Valid ProdutoEntity produto) {
		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(produtosService.postProduto(produto));
	}

	@PutMapping(value = "v1/produtos/{produtoId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoEntity> putProduto(@PathVariable(value = "produtoId") Integer produtoId,
													@RequestBody @Valid ProdutoEntity produto) {
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(produtosService.putProduto(produtoId,produto));
	}

	@DeleteMapping(value = "v1/produtos/{produtoId}")
	public ResponseEntity<Void> deleteProduto(@PathVariable(value = "produtoId") Integer produtoId) {
		produtosService.deleteProduto(produtoId);
		return ResponseEntity.noContent().build();
	}

}
