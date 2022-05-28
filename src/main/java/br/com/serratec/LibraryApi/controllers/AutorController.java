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

import br.com.serratec.LibraryApi.exceptions.AutorExistenteException;
import br.com.serratec.LibraryApi.exceptions.AutorInexistenteException;
import br.com.serratec.LibraryApi.models.Autor;
import br.com.serratec.LibraryApi.services.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	AutorService autorService;
	
	
	@PostMapping
	public ResponseEntity<Autor> createAutor(@Valid @RequestBody Autor autor) throws AutorExistenteException {
		autorService.adicionaAutor(autor);
		return new ResponseEntity<Autor>(autor, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Autor> readAutores() {
		return autorService.retornaAutores();
	}
	
	@GetMapping("/{id}")
	public Autor readAutor(@PathVariable Integer id) throws AutorInexistenteException {
		return autorService.retornaAutor(id);
	}
	
	@PutMapping("/{id}")
	public void updateAutor(@PathVariable Integer id, @Valid Autor atualizacao) throws AutorInexistenteException {
		autorService.atualizaAutor(id, atualizacao);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAutor(@PathVariable Integer id) throws AutorInexistenteException {
		autorService.deletaAutor(id);
	}
}
