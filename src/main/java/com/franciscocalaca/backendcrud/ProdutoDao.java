package com.franciscocalaca.backendcrud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDao extends JpaRepository<Produto, Integer>{

	List<Produto> findByNome(String nome);
	
}
