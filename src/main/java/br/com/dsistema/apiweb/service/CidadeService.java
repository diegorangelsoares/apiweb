package br.com.dsistema.apiweb.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsistema.apiweb.model.Cidade;
import br.com.dsistema.apiweb.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository CidadeRepository;
	
	//Negocio
	public Cidade cadastrar(Cidade Cidade) {
		return CidadeRepository.save(Cidade);
	}
	
	public Collection< Cidade> buscarTodos(){
		return CidadeRepository.findAll();
	}
	
	public void excluir (Cidade Cidade) {
		CidadeRepository.delete(Cidade);
	}
	
	public Cidade buscarPorId(long id) {
		List<Cidade> Cidades = CidadeRepository.findAll();
		Cidade cli = null;
		for (int i = 0; i < Cidades.size(); i++) {
			if (Cidades.get(i).getId() == id) {
				cli = Cidades.get(i);
			}
		}
		return cli;
	}
		
	public Cidade alterar(Cidade Cidade) {
		return CidadeRepository.save(Cidade);
	}
	
	
}
