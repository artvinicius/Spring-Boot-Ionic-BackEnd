package com.arthurvinicius.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arthurvinicius.cursomc.domain.Filme;

@RestController
@RequestMapping(value="/filmes")
public class FilmeResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Filme> listar() {
		
		Filme fil1 = new Filme(1, "ABC");
		Filme fil2 = new Filme(1, "Arthuros");
		
		List<Filme> lista = new ArrayList<>();
		lista.add(fil1);
		lista.add(fil2);
		
		return lista;
	}
}
