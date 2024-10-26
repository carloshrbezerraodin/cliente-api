package com.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliente.model.Cliente;
import com.cliente.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public void excluir(Cliente produto) throws Exception {
		clienteRepository.delete(produto);
	}

	public Cliente salvarOrAtualizar(Cliente produto) throws Exception {
		return clienteRepository.save(produto);
	}

	public List<Cliente> listar() throws Exception {
		return clienteRepository.findAll();
	}
	
	
	public Cliente buscar(Long id) throws Exception {
		return clienteRepository.findById(id).get();
	}

}
