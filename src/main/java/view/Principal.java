package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.dao.PessoaDAO;
import model.vo.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		/***
		 * Banco.getConnection();
		 System.out.println("OK");
		 */
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Maria");
		pessoa.setDataNascimento(LocalDate.parse("11/11/1990", dataFormatter));	
		pessoa.setSexo("FEMININO");
		pessoa.setCpf("99999999");
		pessoa.setReacao(5);
		pessoa.setDataVacinacao(LocalDate.parse("01/08/2020", dataFormatter));	
		pessoa.setVoluntario(true);
		
		PessoaDAO.inserir(pessoa);
	}

}
