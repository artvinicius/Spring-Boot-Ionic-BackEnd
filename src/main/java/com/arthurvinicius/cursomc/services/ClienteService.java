package com.arthurvinicius.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurvinicius.cursomc.domain.Cliente;
import com.arthurvinicius.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.arthurvinicius.cursomc.services.exceptions.ObjectNotFoundException(
				"Cliente não encontrado ! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
