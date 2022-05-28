package br.com.serratec.LibraryApi.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String nome;
	
	@ManyToOne
	@NotNull
	private Categoria categoria;
	
	@ManyToMany
	@NotNull
	private List<Autor> autores;
	
	
	public Livro() {
		super();
	}

	public Livro(Integer id, @NotNull String nome, @NotNull Categoria categoria, @NotNull List<Autor> autores) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.autores = autores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
}
