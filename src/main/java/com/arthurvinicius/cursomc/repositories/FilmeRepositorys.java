package com.arthurvinicius.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arthurvinicius.cursomc.domain.Filme;

@Repository
public interface FilmeRepositorys extends JpaRepository<Filme, Integer>{
	Filme findById(long id);
	
}
