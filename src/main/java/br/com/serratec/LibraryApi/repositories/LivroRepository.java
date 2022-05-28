package br.com.serratec.LibraryApi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.LibraryApi.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

	Optional<Livro> findByNome(String nome);

}
