package com.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.model.Cliente;
import com.cliente.producer.QueueClienteSender;
import com.cliente.service.ClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	QueueClienteSender queueClienteSender;
	
	
	@PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) throws Exception {
        try {
            return this.clienteService.salvarOrAtualizar(cliente);
        } catch (Exception e) {
            throw new Exception();
        }
    }
	
	@PutMapping
    public Cliente atualizar(@RequestBody Cliente cliente) throws Exception {
        try {
            return this.clienteService.salvarOrAtualizar(cliente);
        } catch (Exception e) {
            throw new Exception();
        }
    }
	
    @GetMapping
    public List<Cliente> listar() throws Exception {
        try {
            return this.clienteService.listar();
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    @GetMapping("{id}")
    public Cliente buscar(@PathVariable Long id) throws Exception {
        try {
            return this.clienteService.buscar(id);
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    
    @DeleteMapping("/deletar")
    public void excluri(@RequestBody Cliente produto) throws Exception {
        try {
            this.clienteService.excluir(produto);
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    
    @GetMapping("/enviar-fila")
    public String send(){
    	queueClienteSender.send("test message");
        return "ok. done";
    }
    


}
