package com.arthurvinicius.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.arthurvinicius.cursomc.domain.Filme;

import org.hibernate.validator.constraints.Length;

public class FilmeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	// Class Criada para Trânsferir os dados
	// que quero trafegar quando for fazer
	// operações básicas de Filme.

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório! ")
	@Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 a 80 caracteres!")
	private String nomeFilme;

	public FilmeDTO() {

	}

	public FilmeDTO(Filme obj) {
		id = obj.getId();
		nomeFilme = obj.getNomefilme();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

}
