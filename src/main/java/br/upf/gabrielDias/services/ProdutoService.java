package br.upf.gabrielDias.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.upf.gabrielDias.entity.ProdutoEntity;
import br.upf.gabrielDias.repositories.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ProdutoEntity getProduto(Integer produtoId) throws Exception {
		log.info("ProdutoService.getProduto - start - produtoId: {}", produtoId);

		ProdutoEntity produtoEntity = produtoRepository.findById(produtoId);
		if(ObjectUtils.isEmpty(produtoEntity) ) {
			throw new Exception("Id do Produto Invalida");
		}
		log.info("ProdutoService.getProduto - end - produtoId: {}", produtoId);
		
		return produtoEntity;
	}

	public ProdutoEntity postProduto(ProdutoEntity produto) throws Exception {
		log.info("ProdutoService.postProduto - start -- produtoId: {}", produto);

		if(!ObjectUtils.isEmpty(produtoRepository.findById(produto.getId())) ) {
			throw new Exception("Id do Produto Invalida");
		}
		
		validaQuantidadeEPreco(produto);
		
		ProdutoEntity produtoEntity = produtoRepository.save(produto);
		log.info("ProdutoService.postProduto - end -- produtoId: {}", produto);

		return produtoEntity;
	}


	public ProdutoEntity putProduto(Integer produtoId, ProdutoEntity produto) throws Exception {
		log.info("ProdutosService.putProduto - start -- produtoId: {}", produtoId);

		ProdutoEntity produtoEntity = produtoRepository.findById(produtoId);
		if(ObjectUtils.isEmpty(produtoEntity) ) {
			throw new Exception("Id do Produto Invalida");
		}
		validaQuantidadeEPreco(produto);

		modelMapper.map(produto, produtoEntity);
		produtoRepository.save(produtoEntity);
		log.info("ProdutoService.putProduto - end -- produtoId: {}", produtoId);

		return produtoEntity;
	}

	public void deleteProduto(Integer produtoId) throws Exception {
		log.info("ProdutoService.deleteProduto - start -- produtoId: {}", produtoId);

		if(ObjectUtils.isEmpty(produtoRepository.findById(produtoId)) ) {
			throw new Exception("Id do Produto Invalida");
		}
		produtoRepository.delete(produtoId);
		
		log.info("ProdutoService.deleteProduto - end -- produtoId: {}", produtoId);
		
	}
	
	private void validaQuantidadeEPreco(ProdutoEntity produto) throws Exception {
		if(produto.getQuantidade() < 0 ){
			throw new Exception("Quantidade menor que 0");
		}
		if( produto.getPreco() < 0){
			throw new Exception("Preco menor que 0");
		}
	}
}
