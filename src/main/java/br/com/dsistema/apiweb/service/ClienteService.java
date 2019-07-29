package br.com.dsistema.apiweb.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsistema.apiweb.model.Cliente;
import br.com.dsistema.apiweb.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	//Negocio
	public Cliente cadastrar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Collection< Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public void excluir (Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	public Cliente buscarPorId(long id) {
		List<Cliente> clientes = clienteRepository.findAll();
		Cliente cli = null;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getId() == id) {
				cli = clientes.get(i);
			}
		}
		return cli;
	}
		
	public Cliente alterar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
}
