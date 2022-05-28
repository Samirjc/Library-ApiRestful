package br.com.serratec.LibraryApi.models;

import java.util.List;

public class LivroDTO {
	private Integer id;
	private String nome;
	private Integer categoriaId;
	private List<Integer> autoresId;
	
	
	public LivroDTO() {
		super();
	}

	public LivroDTO(Integer id, String nome, Integer categoriaId, List<Integer> autoresId) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoriaId = categoriaId;
		this.autoresId = autoresId;
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
	
	public Integer getCategoriaId() {
		return categoriaId;
	}
	
	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	public List<Integer> getAutoresId() {
		return autoresId;
	}
	
	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}
}
