package com.arthurvinicius.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arthurvinicius.cursomc.domain.Filme;
import com.arthurvinicius.cursomc.repositories.FilmeRepositorys;

@SpringBootApplication
public class CursomApplication implements CommandLineRunner {

	@Autowired
	private FilmeRepositorys filmeRepositorys;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Filme cat1 = new Filme(null, "Ação");
		Filme cat2 = new Filme(null, "Aventura");
	
	filmeRepositorys.saveAll(Arrays.asList(cat1,cat2));
		
	}	

}
