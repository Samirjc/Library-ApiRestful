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

import br.com.serratec.LibraryApi.exceptions.AutorInexistenteException;
import br.com.serratec.LibraryApi.exceptions.CategoriaInexistenteException;
import br.com.serratec.LibraryApi.exceptions.LivroExistenteException;
import br.com.serratec.LibraryApi.exceptions.LivroInexistenteException;
import br.com.serratec.LibraryApi.mappers.LivroMapper;
import br.com.serratec.LibraryApi.models.Livro;
import br.com.serratec.LibraryApi.models.LivroDTO;
import br.com.serratec.LibraryApi.services.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@Autowired
	LivroMapper livroMapper;
	
	
	@PostMapping
	public ResponseEntity<Livro> createLivro(@Valid @RequestBody LivroDTO livroDTO) throws LivroExistenteException, CategoriaInexistenteException, AutorInexistenteException {
		livroService.adicionaLivro(livroMapper.LivroDtoToLivro(livroDTO));
		return new ResponseEntity<Livro>(livroMapper.LivroDtoToLivro(livroDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Livro> readLivros() {
		return livroService.retornaLivros();
	}
	
	@GetMapping("/{id}")
	public Livro readLivro(@PathVariable Integer id) throws LivroInexistenteException {
		return livroService.retornaLivro(id);
	}
	
	@PutMapping("/{id}")
	public void updateLivro(@PathVariable Integer id, @Valid @RequestBody LivroDTO atualizacao) throws LivroInexistenteException, CategoriaInexistenteException, AutorInexistenteException {
		livroService.atualizaLivro(id, livroMapper.LivroDtoToLivro(atualizacao));
	}
	
	@DeleteMapping("/{id}")
	public void deleteLivro(@PathVariable Integer id) throws LivroInexistenteException {
		livroService.deletaLivro(id);
	}
}
