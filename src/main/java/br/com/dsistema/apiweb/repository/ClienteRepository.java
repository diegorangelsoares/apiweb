package br.com.dsistema.apiweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.dsistema.apiweb.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	

	/*
	@Query("SELECT c FROM TAB_CLIENTE c WHERE LOWER(c.id)")
    Cliente findByID(@Param("searchTerm") Integer searchTerm);
	*/


}
