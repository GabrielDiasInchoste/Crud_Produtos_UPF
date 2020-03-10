package br.upf.gabrielDias.services;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.upf.gabrielDias.entity.ProdutoEntity;
import br.upf.gabrielDias.repositories.ProdutoRepository;

public class ProdutosService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public ProdutoEntity getProduto(Integer produtoId) {

		ProdutoEntity produtoEntity = produtoRepository.findById(produtoId);
		return produtoEntity;
	}

	public ProdutoEntity postProduto(@Valid ProdutoEntity produto) {

		ProdutoEntity produtoEntity = produtoRepository.save(produto);
		return produtoEntity;
	}

	public ProdutoEntity putProduto(Integer produtoId,ProdutoEntity produto) {

		ProdutoEntity produtoEntity = produtoRepository.findById(produtoId);
		modelMapper.map(produto, produtoEntity);
		produtoRepository.save(produtoEntity);
		return produtoEntity;
	}

	public void deleteProduto(Integer produtoId) {
		produtoRepository.findById(produtoId);
	}

}
