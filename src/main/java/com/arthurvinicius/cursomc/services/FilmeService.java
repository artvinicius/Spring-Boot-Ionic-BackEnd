package com.arthurvinicius.cursomc.services;

import java.util.List;
import java.util.Optional;

import com.arthurvinicius.cursomc.domain.Filme;
import com.arthurvinicius.cursomc.dto.FilmeDTO;
import com.arthurvinicius.cursomc.repositories.FilmeRepositorys;
import com.arthurvinicius.cursomc.services.exceptions.DataintegrityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

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
		Filme newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
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

	public Page<Filme> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);

	}

	public Filme fromDTO(FilmeDTO objDto) {
		return new Filme(objDto.getId(), objDto.getNomeFilme());
	}

	private void updateData(Filme newObj, Filme obj) {
		newObj.setNomefilme(obj.getNomefilme());

	}

}
