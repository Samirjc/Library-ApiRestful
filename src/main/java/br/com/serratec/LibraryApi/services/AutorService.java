package br.com.serratec.LibraryApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.LibraryApi.exceptions.AutorExistenteException;
import br.com.serratec.LibraryApi.exceptions.AutorInexistenteException;
import br.com.serratec.LibraryApi.models.Autor;
import br.com.serratec.LibraryApi.repositories.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	AutorRepository repositorio;
	
	
	public void adicionaAutor(Autor autor) throws AutorExistenteException {
		Optional<Autor> autorEncontrado = repositorio.findByNome(autor.getNome());
		
		if(autorEncontrado.isPresent()) {
			throw new AutorExistenteException();
		}
		
		repositorio.save(autor);
	}
	
	public List<Autor> retornaAutores() {
		return repositorio.findAll();
	}
	
	public Autor retornaAutor(Integer id) throws AutorInexistenteException {
		Optional<Autor> autorEncontrado = repositorio.findById(id);
		
		if(!autorEncontrado.isPresent()) {
			throw new AutorInexistenteException();
		}
		
		return autorEncontrado.get();
	}
	
	public void atualizaAutor(Integer id, Autor atualizacao) throws AutorInexistenteException {
		Optional<Autor> autorEncontrado = repositorio.findById(id);
		
		if(!autorEncontrado.isPresent()) {
			throw new AutorInexistenteException();
		}
		
		if(atualizacao.getNome() != null) {
			autorEncontrado.get().setNome(atualizacao.getNome());
		}
		
		repositorio.save(autorEncontrado.get());
	}
	
	public void deletaAutor(Integer id) throws AutorInexistenteException {
		Optional<Autor> autorEncontrado = repositorio.findById(id);
		
		if(!autorEncontrado.isPresent()) {
			throw new AutorInexistenteException();
		}
		
		repositorio.delete(autorEncontrado.get());
	}
}
