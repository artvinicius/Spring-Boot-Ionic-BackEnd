package com.arthurvinicius.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arthurvinicius.cursomc.domain.SalaCinema;

@Repository
public interface SalaCinemaRepositorys extends JpaRepository<SalaCinema, Integer>{
	
}
