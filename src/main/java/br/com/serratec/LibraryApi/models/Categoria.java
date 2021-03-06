package br.com.serratec.LibraryApi.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String nome;
	
	private String descricao;
	
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros;

	
	public Categoria() {
		super();
	}
	
	
	public Categoria(Integer id, @NotNull String nome, String descricao, List<Livro> livros) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.livros = livros;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
