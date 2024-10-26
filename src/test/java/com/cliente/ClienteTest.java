package com.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cliente.model.Cliente;
import com.cliente.service.ClienteService;

@SpringBootTest
public class ClienteTest {
	
	
	@Autowired
	ClienteService produtoSerivce;
	

	@Test
	public void testSalvarProduto() throws Exception {

		Cliente produto = Cliente.builder().nome("Teste produto").endereco("Rua A").build();
		Cliente produtoDB = produtoSerivce.salvarOrAtualizar(produto);
		assertEquals(produto.getNome(), produtoDB.getNome());
	}

	@Test
	public void testListarProduto() throws Exception {
		
		List<Cliente> listarProduto = produtoSerivce.listar();
		
		assertTrue(listarProduto.size() > 0);

	}
	
}
