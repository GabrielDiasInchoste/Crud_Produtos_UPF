package br.upf.gabrielDias.services;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

	public ProdutoEntity getProduto(Integer produtoId) throws Exception {
		log.info("ProdutosService.getProduto - start - produtoId: {}", produtoId);

		ProdutoEntity produtoEntity = produtoRepository.findById(produtoId);
		if(ObjectUtils.isEmpty(produtoEntity) ) {
			throw new Exception("Id do Produto Invalida");
		}
		log.info("ProdutosService.getProduto - end - produtoId: {}", produtoId);
		
		return produtoEntity;
	}

	public ProdutoEntity postProduto(@Valid ProdutoEntity produto) throws Exception {
		log.info("ProdutosService.postProduto - start -- produtoId: {}", produto);

		if(!ObjectUtils.isEmpty(produtoRepository.findById(produto.getId())) ) {
			throw new Exception("Id do Produto Invalida");
		}
		ProdutoEntity produtoEntity = produtoRepository.save(produto);
		log.info("ProdutosService.postProduto - end -- produtoId: {}", produto);

		return produtoEntity;
	}

	public ProdutoEntity putProduto(Integer produtoId, ProdutoEntity produto) throws Exception {
		log.info("ProdutosService.putProduto - start -- produtoId: {}", produtoId);

		ProdutoEntity produtoEntity = produtoRepository.findById(produtoId);
		if(ObjectUtils.isEmpty(produtoEntity) ) {
			throw new Exception("Id do Produto Invalida");
		}
		modelMapper.map(produto, produtoEntity);
		produtoEntity.setId(produtoId);
		produtoRepository.save(produtoEntity);
		log.info("ProdutosService.putProduto - end -- produtoId: {}", produtoId);

		return produtoEntity;
	}

	public void deleteProduto(Integer produtoId) throws Exception {
		log.info("ProdutosService.deleteProduto - start -- produtoId: {}", produtoId);

		if(!ObjectUtils.isEmpty(produtoRepository.findById(produtoId)) ) {
			throw new Exception("Id do Produto Invalida");
		}
		produtoRepository.delete(produtoId);
		
		log.info("ProdutosService.deleteProduto - end -- produtoId: {}", produtoId);
		
	}
}
