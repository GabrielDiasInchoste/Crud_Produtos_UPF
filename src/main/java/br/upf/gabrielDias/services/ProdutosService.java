package br.upf.gabrielDias.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.upf.gabrielDias.dto.ProdutosDTO;
import br.upf.gabrielDias.repositories.ProdutoRepository;

public class ProdutosService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ProdutosDTO getProduto(Integer produtoId) {
		produtoRepository.findById(produtoId);
		ProdutosDTO produtosDTO = new ProdutosDTO();
		
		return produtosDTO;
	}

}
