package br.upf.gabrielDias;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.upf.gabrielDias.controller.ProdutoController;
import br.upf.gabrielDias.entity.ProdutoEntity;
import br.upf.gabrielDias.repositories.ProdutoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTest {

	@Autowired
	private ProdutoController produtoController;

	@MockBean
	private ProdutoRepository produtoRepository;

	@Before
	public void setup() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	@Test
	public void getProdutoTest() throws Exception {

		when(produtoRepository.findById(Mockito.anyInt())).thenReturn(new ProdutoEntity());

		ResponseEntity<ProdutoEntity> responseEntity = produtoController.getProduto(1);

		Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void putProdutoTest() throws Exception {

		ProdutoEntity mockProdutoEntity = mockProdutoEntity();
		mockProdutoEntity.setNome("Teclado");
		when(produtoRepository.findById(Mockito.anyInt())).thenReturn(mockProdutoEntity);

		ResponseEntity<ProdutoEntity> responseEntity = produtoController.putProduto(1, mockProdutoEntity());
		Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		Assert.assertEquals(mockProdutoEntity(), responseEntity.getBody());

	}

	@Test
	public void postProdutoTest() throws Exception {

		when(produtoRepository.findById(Mockito.anyInt())).thenReturn(null);

		ResponseEntity<ProdutoEntity> responseEntity = produtoController.postProduto(mockProdutoEntity());

		Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
	}

	@Test
	public void deleteProdutoTest() throws Exception {

		when(produtoRepository.findById(Mockito.anyInt())).thenReturn(new ProdutoEntity());

		ResponseEntity<Void> responseEntity = produtoController.deleteProduto(1);

		Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.NO_CONTENT);
	}

	@Test(expected = Exception.class)
	public void deleteProdutoTestError() throws Exception {

		when(produtoRepository.findById(Mockito.anyInt())).thenReturn(null);

		produtoController.deleteProduto(1);

	}

	@Test(expected = Exception.class)
	public void getProdutoTestError() throws Exception {

		when(produtoRepository.findById(Mockito.anyInt())).thenReturn(null);

		produtoController.getProduto(1);

	}

	@Test(expected = Exception.class)
	public void putProdutoTestError() throws Exception {

		when(produtoRepository.findById(Mockito.anyInt())).thenReturn(null);

		produtoController.putProduto(1, mockProdutoEntity());

	}

	@Test(expected = Exception.class)
	public void postProdutoTestError() throws Exception {

		when(produtoRepository.findById(Mockito.anyInt())).thenReturn(mockProdutoEntity());

		produtoController.postProduto(mockProdutoEntity());

	}

	@Test(expected = Exception.class)
	public void validaQuantidadeEPrecoErrorQuantidade() throws Exception {

		when(produtoRepository.findById(Mockito.anyInt())).thenReturn(null);
		ProdutoEntity mockProdutoEntity = mockProdutoEntity();
		mockProdutoEntity.setQuantidade(-10D);

		produtoController.postProduto(mockProdutoEntity);

	}

	@Test(expected = Exception.class)
	public void validaQuantidadeEPrecoErrorpreco() throws Exception {

		when(produtoRepository.findById(Mockito.anyInt())).thenReturn(null);
		ProdutoEntity mockProdutoEntity = mockProdutoEntity();
		mockProdutoEntity.setPreco(-10D);
		produtoController.postProduto(mockProdutoEntity);

	}

	private ProdutoEntity mockProdutoEntity() {

		ProdutoEntity produto = new ProdutoEntity();
		produto.setId(1);
		produto.setNome("TV");
		produto.setDescricao("50 Polegadas");
		produto.setPreco(100D);
		produto.setQuantidade(10D);
		produto.setTipo("Eletronico");

		return produto;
	}

}
