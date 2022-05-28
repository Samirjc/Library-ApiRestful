package br.com.serratec.LibraryApi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.LibraryApi.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	Optional<Categoria> findByNome(String nome);
	
}
