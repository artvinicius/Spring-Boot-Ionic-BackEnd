package com.arthurvinicius.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurvinicius.cursomc.domain.Pedido;
import com.arthurvinicius.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.arthurvinicius.cursomc.services.exceptions.ObjectNotFoundException(
				"Pedido não encontrado ! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
