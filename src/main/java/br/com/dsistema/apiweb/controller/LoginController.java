package br.com.dsistema.apiweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dsistema.apiweb.model.Usuario;
import br.com.dsistema.apiweb.service.UsuarioService;


@RestController
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	//End point
		@RequestMapping(method = RequestMethod.POST, value="/autenticar",consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Usuario> autenticar(@RequestBody Usuario usuario) {
			System.out.println( usuario.getNome());
			//consulta no banco
			Usuario usuarioAutenticado = usuarioService.buscarPorNome(usuario.getNome());
			
			
			
			return new ResponseEntity<Usuario>(usuarioAutenticado, HttpStatus.OK);
		}
		
		

}
