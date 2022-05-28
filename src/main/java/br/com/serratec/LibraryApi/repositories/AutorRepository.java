package br.com.serratec.LibraryApi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.LibraryApi.models.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer>{

	Optional<Autor> findByNome(String nome);

}
