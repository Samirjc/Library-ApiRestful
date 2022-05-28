package br.com.serratec.LibraryApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.LibraryApi.exceptions.CategoriaExistenteException;
import br.com.serratec.LibraryApi.exceptions.CategoriaInexistenteException;
import br.com.serratec.LibraryApi.models.Categoria;
import br.com.serratec.LibraryApi.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	
	@PostMapping
	public ResponseEntity<Categoria> createCategoria(@Valid @RequestBody Categoria categoria) throws CategoriaExistenteException {
		categoriaService.adicionaCategoria(categoria);
		return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Categoria> readCategorias() {
		return categoriaService.retornaCategorias();
	}
	
	@GetMapping("/{id}")
	public Categoria readCategoria(@PathVariable Integer id) throws CategoriaInexistenteException {
		return categoriaService.retornaCategoria(id);
	}
	
	@PutMapping("/{id}")
	public void updateCategoria(@PathVariable Integer id, @Valid @RequestBody Categoria atualizacao) throws CategoriaInexistenteException {
		categoriaService.atualizaCategoria(id, atualizacao);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Integer id) throws CategoriaInexistenteException {
		categoriaService.deletaCategoria(id);
	}
}
