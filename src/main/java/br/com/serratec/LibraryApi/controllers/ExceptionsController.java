package br.com.serratec.LibraryApi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.serratec.LibraryApi.exceptions.AutorExistenteException;
import br.com.serratec.LibraryApi.exceptions.AutorInexistenteException;
import br.com.serratec.LibraryApi.exceptions.CategoriaExistenteException;
import br.com.serratec.LibraryApi.exceptions.CategoriaInexistenteException;
import br.com.serratec.LibraryApi.exceptions.LivroExistenteException;
import br.com.serratec.LibraryApi.exceptions.LivroInexistenteException;

@RestControllerAdvice
public class ExceptionsController {
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<String> handleAutorExistente() {
		String msg = "Autor já existe";
		return ResponseEntity.badRequest().header("error-msg", msg).build();
	}
	
	@ExceptionHandler(AutorInexistenteException.class)
	public ResponseEntity<String> handleAutorInexistente() {
		String msg = "Autor não existe";
		return ResponseEntity.badRequest().header("error-msg", msg).build();
	}
	
	@ExceptionHandler(CategoriaExistenteException.class)
	public ResponseEntity<String> handleCategoriaExistente() {
		String msg = "Categoria já existe";
		return ResponseEntity.badRequest().header("error-msg", msg).build();
	}
	
	@ExceptionHandler(CategoriaInexistenteException.class)
	public ResponseEntity<String> handleCategoriaInexistente() {
		String msg = "Categoria não existe";
		return ResponseEntity.badRequest().header("error-msg", msg).build();
	}
	
	@ExceptionHandler(LivroExistenteException.class)
	public ResponseEntity<String> handleLivroExistente() {
		String msg = "Livro já existe";
		return ResponseEntity.badRequest().header("error-msg", msg).build();
	}
	
	@ExceptionHandler(LivroInexistenteException.class)
	public ResponseEntity<String> handleLivroInexistente() {
		String msg = "Livro não existe";
		return ResponseEntity.badRequest().header("error-msg", msg).build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidacao(MethodArgumentNotValidException ex) {
		Map<String, String> errosMap = new HashMap<>();
		List<ObjectError> erros = ex.getBindingResult().getAllErrors();
		
		for(ObjectError erro : erros) {
			String atributo = ((FieldError) erro).getField();
			String msg = erro.getDefaultMessage();
			errosMap.put(atributo, msg);
		}
		
		return new ResponseEntity<Map<String, String>>(errosMap, HttpStatus.BAD_REQUEST);
	}
}
