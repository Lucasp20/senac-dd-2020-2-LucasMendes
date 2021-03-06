package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.dao.Banco;
import model.dao.InstituicaoDAO;
import model.dao.PessoaDAO;
import model.vo.Instituicao;
import model.vo.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		/*Banco.getConnection();
		 System.out.println("OK"); */
		 
		/*DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Bruna Pereira");
		pessoa.setDataNascimento(LocalDate.parse("11/11/1990", dataFormatter));	
		pessoa.setSexo("Feminino");
		pessoa.setCpf("232323232");
		pessoa.setReacao(4);
		pessoa.setDataVacinacao(LocalDate.parse("08/01/2020", dataFormatter));	
		pessoa.setVoluntario(true);
		
		PessoaDAO.inserir(pessoa); 
		
		PessoaDAO.excluir(2); 
		
		PessoaDAO.pesquisarTodos(); 
		
		System.out.println(PessoaDAO.pesquisarTodos()); 
		
		System.out.println(PessoaDAO.pesquisarPorId(1)); */
		
		
		
		Instituicao instituicao = new Instituicao();
		instituicao.setNome("Baia Sul");
		instituicao.setRua("Mauro Ramos");
		instituicao.setBairro("Centro");
		instituicao.setCidade("Floripa");
		instituicao.setEstado("SC");
		instituicao.setCnpj("087666595");
	
		InstituicaoDAO.inserir(instituicao);
	}
}
