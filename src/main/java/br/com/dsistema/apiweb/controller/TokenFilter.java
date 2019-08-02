package br.com.dsistema.apiweb.controller;

import java.io.IOException;
import java.security.Key;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


public class TokenFilter extends GenericFilterBean{
	
	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			HttpServletRequest req = (HttpServletRequest) request;
			String header = req.getHeader("Authotization");
			
			if (header == null || !header.startsWith("Bearer ")) {
				throw new ServletException("Token inexistente ou inválido.");
			}
			
			String token = header.substring(7); //extraindo so o token
			
			//verificar token
			try {
			Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
			}catch (Exception e) {
				throw new ServletException("Token inválido.");
			}
			
			chain.doFilter(request, response);
			
	}

}
