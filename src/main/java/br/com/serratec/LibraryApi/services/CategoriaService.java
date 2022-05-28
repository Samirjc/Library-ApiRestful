package br.com.serratec.LibraryApi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.LibraryApi.exceptions.CategoriaExistenteException;
import br.com.serratec.LibraryApi.exceptions.CategoriaInexistenteException;
import br.com.serratec.LibraryApi.models.Categoria;
import br.com.serratec.LibraryApi.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repositorio;
	
	public void adicionaCategoria(Categoria categoria) throws CategoriaExistenteException {
		Optional<Categoria> categoriaEncontrada = repositorio.findByNome(categoria.getNome());
		
		if(categoriaEncontrada.isPresent()) {
			throw new CategoriaExistenteException();
		}
		repositorio.save(categoria);
	}
	
	public List<Categoria> retornaCategorias() {
		return repositorio.findAll();
	}
	
	public Categoria retornaCategoria(Integer id) throws CategoriaInexistenteException {
		Optional<Categoria> categoriaEncontrada = repositorio.findById(id);
		
		if(!categoriaEncontrada.isPresent()) {
			throw new CategoriaInexistenteException();
		}
		
		return categoriaEncontrada.get();
	}
	
	public void atualizaCategoria(Integer id, Categoria atualizacao) throws CategoriaInexistenteException {
		Optional<Categoria> categoriaEncontrada = repositorio.findById(id);
		
		if(!categoriaEncontrada.isPresent()) {
			throw new CategoriaInexistenteException();
		}
		
		if(atualizacao.getNome() != null) {
			categoriaEncontrada.get().setNome(atualizacao.getNome());
		}
		if(atualizacao.getDescricao() != null) {
			categoriaEncontrada.get().setDescricao(atualizacao.getDescricao());
		}
		
		repositorio.save(categoriaEncontrada.get());
	}
	
	public void deletaCategoria(Integer id) throws CategoriaInexistenteException {
		Optional<Categoria> categoriaEncontrada = repositorio.findById(id);
		
		if(!categoriaEncontrada.isPresent()) {
			throw new CategoriaInexistenteException();
		}
		
		repositorio.delete(categoriaEncontrada.get());
	}
}
