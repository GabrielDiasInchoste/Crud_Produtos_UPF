package br.upf.gabrielDias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.upf.gabrielDias.dto.ProdutosDTO;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutosDTO, String> {

	ProdutosDTO findById(Integer id);
	
}
