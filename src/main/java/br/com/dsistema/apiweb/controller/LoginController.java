package br.com.dsistema.apiweb.controller;

import java.security.Key;
import java.util.Date;

import javax.servlet.ServletException;
import javax.xml.crypto.AlgorithmMethod;

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
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@RestController
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	//End point
	@RequestMapping(method = RequestMethod.POST, value="/autenticar",consumes = MediaType.APPLICATION_JSON_VALUE)
	public loginResponse autenticar(@RequestBody Usuario usuario) throws ServletException {
		
		if ( usuario.getNome() == null) {
			throw new ServletException("Nome e senha obrigatório.");
		}
		Usuario usuarioAutenticado = usuarioService.buscarPorNome(usuario.getNome());
		
		//consulta no banco
		
		if (usuarioAutenticado == null) {
			throw new ServletException("Usuário não encontrado.");
		}
		if (!usuarioAutenticado.getSenha().equals(usuario.getSenha())) {
			throw new ServletException("Usuário ou senha inválido.");
		}

		String token = Jwts.builder()
				.setSubject(usuarioAutenticado.getNome())
				.signWith(key)
				.setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
				.compact();
		return new loginResponse(token);
	}
	
	public class loginResponse{
		
		String token;
		
		public loginResponse(String token) {
			this.token = token;
		}
		
		public String getToken() {
			return token;
		}
		
	
	}
		
		

}
