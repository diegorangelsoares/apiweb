package br.com.dsistema.apiweb.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsistema.apiweb.model.Estado;
import br.com.dsistema.apiweb.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	EstadoRepository EstadoRepository;
	
	//Negocio
	public Estado cadastrar(Estado Estado) {
		return EstadoRepository.save(Estado);
	}
	
	public Collection< Estado> buscarTodos(){
		return EstadoRepository.findAll();
	}
	
	public void excluir (Estado Estado) {
		EstadoRepository.delete(Estado);
	}
	
	public Estado buscarPorId(long id) {
		List<Estado> Estados = EstadoRepository.findAll();
		Estado cli = null;
		for (int i = 0; i < Estados.size(); i++) {
			if (Estados.get(i).getId() == id) {
				cli = Estados.get(i);
			}
		}
		return cli;
	}
		
	public Estado alterar(Estado Estado) {
		return EstadoRepository.save(Estado);
	}
	
	
}