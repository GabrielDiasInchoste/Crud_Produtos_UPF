package br.upf.gabrielDias.services;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.upf.gabrielDias.entity.ProdutoEntity;
import br.upf.gabrielDias.repositories.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProdutosService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ProdutoEntity getProduto(Integer produtoId) {

		log.info("ProdutosService.getProduto - start - produtoId: {}", produtoId);
		ProdutoEntity produtoEntity = produtoRepository.findById(produtoId);
		log.info("ProdutosService.getProduto - end - produtoId: {}", produtoId);

		return produtoEntity;
	}

	public ProdutoEntity postProduto(@Valid ProdutoEntity produto) {
		log.info("ProdutosService.postProduto - start -- produtoId: {}", produto);

		ProdutoEntity produtoEntity = produtoRepository.save(produto);
		log.info("ProdutosService.postProduto - end -- produtoId: {}", produto);

		return produtoEntity;
	}

	public ProdutoEntity putProduto(Integer produtoId, ProdutoEntity produto) {
		log.info("ProdutosService.putProduto - start -- produtoId: {}", produtoId);

		ProdutoEntity produtoEntity = produtoRepository.findById(produtoId);
		modelMapper.map(produto, produtoEntity);
		produtoEntity.setId(produtoId);
		produtoRepository.save(produtoEntity);
		log.info("ProdutosService.putProduto - end -- produtoId: {}", produtoId);

		return produtoEntity;
	}

	public void deleteProduto(Integer produtoId) {
		log.info("ProdutosService.deleteProduto - start -- produtoId: {}", produtoId);

		produtoRepository.delete(produtoId);
		log.info("ProdutosService.deleteProduto - end -- produtoId: {}", produtoId);

	}

}
