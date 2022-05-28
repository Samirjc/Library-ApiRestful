package br.com.serratec.LibraryApi.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.serratec.LibraryApi.exceptions.AutorInexistenteException;
import br.com.serratec.LibraryApi.exceptions.CategoriaInexistenteException;
import br.com.serratec.LibraryApi.models.Autor;
import br.com.serratec.LibraryApi.models.Livro;
import br.com.serratec.LibraryApi.models.LivroDTO;
import br.com.serratec.LibraryApi.services.AutorService;
import br.com.serratec.LibraryApi.services.CategoriaService;

@Component
public class LivroMapper {
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	AutorService autorService;
	
	
	public LivroDTO livroToLivroDto(Livro livro) {
		LivroDTO livroDTO = new LivroDTO();
		List<Integer> autoresId = new ArrayList<>();
		
		livroDTO.setNome(livro.getNome());
		livroDTO.setCategoriaId(livro.getCategoria().getId());
		
		for(Autor autor : livro.getAutores()) {
			autoresId.add(autor.getId());
		}
			
		livroDTO.setAutoresId(autoresId);
		
		return livroDTO;
	}
	
	public Livro LivroDtoToLivro(LivroDTO livroDTO) throws CategoriaInexistenteException, AutorInexistenteException {
		Livro livro = new Livro();
		List<Autor> autores = new ArrayList<>();
		
		livro.setId(livroDTO.getId());
		livro.setNome(livroDTO.getNome());
		livro.setCategoria(categoriaService.retornaCategoria(livroDTO.getCategoriaId()));
		
		for(Integer autor: livroDTO.getAutoresId()) {
			autores.add(autorService.retornaAutor(autor));
		}
			
		livro.setAutores(autores);
		return livro;
	}
}
