package com.arthurvinicius.cursomc;

import java.util.Arrays;
import java.util.Collection;

import com.arthurvinicius.cursomc.domain.Cidade;
import com.arthurvinicius.cursomc.domain.Cliente;
import com.arthurvinicius.cursomc.domain.Endereco;
import com.arthurvinicius.cursomc.domain.Estado;
import com.arthurvinicius.cursomc.domain.Filme;
import com.arthurvinicius.cursomc.domain.SalaCinema;
import com.arthurvinicius.cursomc.domain.enums.TipoCliente;
import com.arthurvinicius.cursomc.repositories.CidadeRepository;
import com.arthurvinicius.cursomc.repositories.ClienteRepository;
import com.arthurvinicius.cursomc.repositories.EnderecoRepository;
import com.arthurvinicius.cursomc.repositories.EstadoRepository;
import com.arthurvinicius.cursomc.repositories.FilmeRepositorys;
import com.arthurvinicius.cursomc.repositories.SalaCinemaRepositorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomApplication implements CommandLineRunner {

	@Autowired
	private FilmeRepositorys filmeRepositorys;

	@Autowired
	private SalaCinemaRepositorys salacinemaRepositorys;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Filme cat1 = new Filme(null, "Coringa");
		Filme cat2 = new Filme(null, "O Irlandês");

		SalaCinema s1 = new SalaCinema(12345, "14:00 PM");
		SalaCinema s2 = new SalaCinema(12346, "18:00 PM");
		SalaCinema s3 = new SalaCinema(12347, "20:10 PM");

		cat1.getFilmes().addAll((Collection<? extends SalaCinema>) Arrays.asList(s1, s2, s3));
		cat2.getFilmes().addAll((Collection<? extends SalaCinema>) Arrays.asList(s2));

		s1.getFilmes().addAll(Arrays.asList(cat1));
		s2.getFilmes().addAll(Arrays.asList(cat1));
		s3.getFilmes().addAll(Arrays.asList(cat1));

		filmeRepositorys.saveAll(Arrays.asList(cat1, cat2));
		salacinemaRepositorys.saveAll(Arrays.asList(s1, s2, s3));

		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "Paraíba");

		Cidade c1 = new Cidade(null, "Carpina", est1);
		Cidade c2 = new Cidade(null, "Recife", est1);
		Cidade c3 = new Cidade(null, "Patos", est2);

		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Arthur Vinícius", "arthurv@gmail.com", "11111111111",
				TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("94119930", "94558541"));

		Endereco e1 = new Endereco(null, "Rua Dr Gonçalves Guerra ", "793", "Casa", "Cajá", "55813390", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Leôncio Ribeiro", "85", "Casa", "Cajá", "55813390", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));

	}

}
