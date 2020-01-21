package com.arthurvinicius.cursomc;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arthurvinicius.cursomc.domain.Filme;
import com.arthurvinicius.cursomc.domain.SalaCinema;
import com.arthurvinicius.cursomc.repositories.FilmeRepositorys;
import com.arthurvinicius.cursomc.repositories.SalaCinemaRepositorys;

@SpringBootApplication
public class CursomApplication implements CommandLineRunner {

	@Autowired
	private FilmeRepositorys filmeRepositorys;

	@Autowired
	private SalaCinemaRepositorys salacinemaRepositorys;

	public static void main(String[] args) {
		SpringApplication.run(CursomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Filme cat1 = new Filme(null, "Coringa");
		Filme cat2 = new Filme(null, "O Irlandês");

		SalaCinema s1 = new SalaCinema(null, "14:00 PM");
		SalaCinema s2 = new SalaCinema(null, "18:00 PM | 19:45PM");
		SalaCinema s3 = new SalaCinema(null, "20:10 PM");

		cat1.getFilmes().addAll((Collection<? extends SalaCinema>) Arrays.asList(s1, s2, s3));
		cat2.getFilmes().addAll((Collection<? extends SalaCinema>) Arrays.asList(s2));

		s1.getFilmes().addAll(Arrays.asList(cat1));
		s2.getFilmes().addAll(Arrays.asList(cat1, cat2));
		s3.getFilmes().addAll(Arrays.asList(cat1));

		filmeRepositorys.saveAll(Arrays.asList(cat1,cat2));
		salacinemaRepositorys.saveAll(Arrays.asList(s1,s2,s3));
		
	}

}
