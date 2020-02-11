package com.arthurvinicius.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class SalaCinema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private String hora;
	private Double preco;

	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "SALACINEMA_FILME", joinColumns = @JoinColumn(name = "salaCinema_id"), inverseJoinColumns = @JoinColumn(name = "filme_id"))

	private List<Filme> filmes = new ArrayList<>();

	@OneToMany(mappedBy = "id.salaCinema")
	private Set<ItemPedido> itens = new HashSet<>();

	public SalaCinema() {

	}

	public SalaCinema(Integer id, String hora, Double preco) {
		super();
		this.id = id;
		this.hora = hora;
		this.preco = preco;
	}

	public List<Pedido> getPedidos() {
		List<Pedido> lista = new ArrayList<>();
		for (ItemPedido x : itens) {
			lista.add(x.getPedido());
		}
		return lista;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(final Double preco) {
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(final List<Filme> filmes) {
		this.filmes = filmes;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(final String hora) {
		this.hora = hora;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SalaCinema other = (SalaCinema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
