package br.com.dsistema.apiweb.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dsistema.apiweb.model.Cidade;
import br.com.dsistema.apiweb.service.CidadeService;

@RestController
public class CidadeController {
	
	@Autowired
	CidadeService cidadeService;

	//End point
	@RequestMapping(method = RequestMethod.POST, value="/cidades",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cidade> cadastrarcidade(@RequestBody Cidade cidade) {
		Cidade cidadeCadastrado = cidadeService.cadastrar(cidade);
		return new ResponseEntity<Cidade>(cidadeCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/cidades",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Cidade>> buscarTodoscidades() {
		Collection< Cidade> cidadesBuscados= cidadeService.buscarTodos();
		return new ResponseEntity<>(cidadesBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/cidades/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Cidade>> excluircidade(@PathVariable Integer id) {
		
		Cidade cidadeEncontrado = cidadeService.buscarPorId(id);
		if (cidadeEncontrado == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			cidadeService.excluir(cidadeEncontrado);
			return new ResponseEntity<>( HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/cidades",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cidade> alterarcidade(@RequestBody Cidade cidade) {
		Cidade cidadeAlterado = cidadeService.alterar(cidade);		
		return new ResponseEntity<Cidade>(cidadeAlterado, HttpStatus.OK);
	}
	
	/**
	//End point TESTE
	@RequestMapping(method = RequestMethod.GET, value="/cidades")
	public void busca() {
		System.out.println("Deu certo");
	}
	*/

}
