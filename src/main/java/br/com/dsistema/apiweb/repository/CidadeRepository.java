package br.com.dsistema.apiweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dsistema.apiweb.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
