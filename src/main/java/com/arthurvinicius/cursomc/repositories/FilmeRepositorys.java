package com.arthurvinicius.cursomc.repositories;

import com.arthurvinicius.cursomc.domain.Filme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepositorys extends JpaRepository<Filme, Integer> {

}
