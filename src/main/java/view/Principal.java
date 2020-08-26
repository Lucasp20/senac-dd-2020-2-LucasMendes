package view;

import model.dao.PessoaDAO;
import model.vo.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		/***
		 * Banco.getConnection();
		 System.out.println("OK");
		 */
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Pereira Lucas");
		pessoa.setDataNascimento("2010-10-12");
		pessoa.setSexo(1);
		pessoa.setCpf("9393939393");
		pessoa.setReacao(1);
		pessoa.setTipoPessoa(1);
		
		PessoaDAO.inserir(pessoa);
	}

}
