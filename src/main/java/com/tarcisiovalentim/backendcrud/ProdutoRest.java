package com.tarcisiovalentim.backendcrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoRest {

	@Autowired
	private ProdutoDao produtoDao;
	
	@GetMapping("/filter/{nome}")
	public List<Produto> filter(@PathVariable String nome){
		return produtoDao.findByNome(nome);
	}
	
	@GetMapping
	public List<Produto> get(){
		return produtoDao.findAll();
	}
	
	@PostMapping
	public void post(@RequestBody Produto produto) {
		produtoDao.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id){
		produtoDao.deleteById(id);;
	}
	
	
	
}
