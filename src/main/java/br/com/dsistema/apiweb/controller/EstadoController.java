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

import br.com.dsistema.apiweb.model.Estado;
import br.com.dsistema.apiweb.service.EstadoService;

@RestController
public class EstadoController {
	
	@Autowired
	EstadoService EstadoService;

	//End point
	@RequestMapping(method = RequestMethod.POST, value="/Estados",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> cadastrarEstado(@RequestBody Estado Estado) {
		Estado EstadoCadastrado = EstadoService.cadastrar(Estado);
		return new ResponseEntity<Estado>(EstadoCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/Estados",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Estado>> buscarTodosEstados() {
		Collection< Estado> EstadosBuscados= EstadoService.buscarTodos();
		return new ResponseEntity<>(EstadosBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/Estados/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Estado>> excluirEstado(@PathVariable Integer id) {
		
		Estado EstadoEncontrado = EstadoService.buscarPorId(id);
		if (EstadoEncontrado == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			EstadoService.excluir(EstadoEncontrado);
			return new ResponseEntity<>( HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/Estados",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> alterarEstado(@RequestBody Estado Estado) {
		Estado EstadoAlterado = EstadoService.alterar(Estado);		
		return new ResponseEntity<Estado>(EstadoAlterado, HttpStatus.OK);
	}
	
	/**
	//End point TESTE
	@RequestMapping(method = RequestMethod.GET, value="/Estados")
	public void busca() {
		System.out.println("Deu certo");
	}
	*/

}
