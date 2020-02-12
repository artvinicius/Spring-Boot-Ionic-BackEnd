package com.arthurvinicius.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.arthurvinicius.cursomc.domain.Filme;
import com.arthurvinicius.cursomc.repositories.FilmeRepositorys;
import com.arthurvinicius.cursomc.services.exceptions.DataintegrityException;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepositorys repo;

	public Filme find(Integer id) {
		Optional<Filme> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.arthurvinicius.cursomc.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado ! Id: " + id + ", Tipo: " + Filme.class.getName()));
	}

	public Filme insert(Filme obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Filme update(Filme obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataintegrityException("Não é possível excluir um Filme que possui uma Sala de Cinema");
		}

	}

	public List<Filme> findAll() {
		return repo.findAll();
	}
}
