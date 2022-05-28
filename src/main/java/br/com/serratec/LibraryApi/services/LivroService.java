package br.com.serratec.LibraryApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.LibraryApi.exceptions.AutorInexistenteException;
import br.com.serratec.LibraryApi.exceptions.CategoriaInexistenteException;
import br.com.serratec.LibraryApi.exceptions.LivroExistenteException;
import br.com.serratec.LibraryApi.exceptions.LivroInexistenteException;
import br.com.serratec.LibraryApi.models.Livro;
import br.com.serratec.LibraryApi.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository repositorio;
	
	//Ideal usar uma classe mapper para jogar os dados da DTO no Livro padrão
	public void adicionaLivro(Livro livro) throws LivroExistenteException, CategoriaInexistenteException, AutorInexistenteException {
		Optional<Livro> livroAchado = repositorio.findByNome(livro.getNome());
		
		if(livroAchado.isPresent()) {
			throw new LivroExistenteException();
		}
		
		repositorio.save(livro);
	}
	
	public List<Livro> retornaLivros() {
		return repositorio.findAll();
	}
	
	public Livro retornaLivro(Integer id) throws LivroInexistenteException {
		Optional<Livro> livroAchado = repositorio.findById(id);
		
		if(!livroAchado.isPresent()) {
			throw new LivroInexistenteException();
		}
		
		return livroAchado.get();
	}
	
	public void atualizaLivro(Integer id, Livro atualizacao) throws LivroInexistenteException {
		Optional<Livro> livroAchado = repositorio.findById(id);
		
		if(!livroAchado.isPresent()) {
			throw new LivroInexistenteException();
		}
		
		if(atualizacao.getNome() != null) {
			livroAchado.get().setNome(atualizacao.getNome());
		}
		if(atualizacao.getCategoria() != null) {
			livroAchado.get().setCategoria(atualizacao.getCategoria());
		}
		if(atualizacao.getNome() != null) {
			livroAchado.get().setAutores(atualizacao.getAutores());
		}
	}
	
	public void deletaLivro(Integer id) throws LivroInexistenteException {
		Optional<Livro> livroAchado = repositorio.findById(id);
		
		if(!livroAchado.isPresent()) {
			throw new LivroInexistenteException();
		}
		
		repositorio.delete(livroAchado.get());
	}
}
