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
		pessoa.setNome("Pereira Lucas");
		pessoa.setDataNascimento(LocalDate.parse("10/10/2000", dataFormatter));	
		pessoa.setSexo("MASCULINO");
		pessoa.setCpf("9393939393");
		pessoa.setReacao(1);
		pessoa.setDataVacinacao(LocalDate.parse("12/08/2020", dataFormatter));	
		pessoa.setVoluntario(false);
		
		PessoaDAO.inserir(pessoa);
	}

}
