package br.upf.gabrielDias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.upf.gabrielDias.dto.ProdutosDTO;
import br.upf.gabrielDias.services.ProdutosService;


public class ProdutosController {

	@Autowired
	private ProdutosService produtosService;
	
    @GetMapping(value = "/v1/categories/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutosDTO> queryCategory(@PathVariable(value = "produtoId") Integer produtoId) {
        return ResponseEntity.status(HttpStatus.OK).body(produtosService.getProduto(produtoId));
    }
	
	
}
