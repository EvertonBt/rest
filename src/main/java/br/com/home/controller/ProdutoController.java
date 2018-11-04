package br.com.home.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.home.model.Produto;
import br.com.home.model.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	

	
	@GetMapping("/{id}")
	public Produto pesquisar(@PathVariable Long id){
		
		Optional <Produto> produto =  repository.findById(id);
		if(produto.isPresent()){
		
		return produto.get();
		
		}
		return null;
	}
	
	@GetMapping
	public List<Produto> listar(){
		return repository.findAll();
		
	}
	
	@PostMapping
	public Produto salvar(@RequestBody Produto produto){
		return repository.save(produto);
		
	}

	@PutMapping
	public Produto atualizar(@RequestBody Produto produto){
		return repository.save(produto);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id){
		repository.deleteById(id);
	}
	
}
