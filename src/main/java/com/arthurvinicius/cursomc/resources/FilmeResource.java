package com.arthurvinicius.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arthurvinicius.cursomc.domain.Filme;
import com.arthurvinicius.cursomc.services.FilmeService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeResource {

	@Autowired
	private FilmeService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Filme obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}
}
