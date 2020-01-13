package com.arthurvinicius.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/filmes")
public class FilmeResource {

	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "Filmes estão funcionando";
	}
}
