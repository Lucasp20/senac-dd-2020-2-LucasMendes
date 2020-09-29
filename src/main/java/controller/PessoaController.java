package controller;

import model.dao.PessoaDAO;
import model.vo.Pessoa;

public class PessoaController {

	private String mensagem = "";
	
	public String cadastrarPessoa(Pessoa pessoa) {
		
			if(validarNome(pessoa) 
					&& validarCpf(pessoa) 
					&& validarSexo(pessoa)) {
				PessoaDAO pessoaDAO = new PessoaDAO();
				pessoaDAO.inserir(pessoa);
		
			mensagem = "Pessoa cadastrada com sucesso";
		}
		return mensagem;
	}


	private boolean validarNome(Pessoa pessoa) {
		if(pessoa.getNome().length() < 3 
				|| pessoa.getNome() == null 
				|| pessoa.getNome().isEmpty() ) {
			mensagem = "Nome deve conter ao menos três catacteres";
			return false;
		}
		return true;
	}
	
	private boolean validarCpf(Pessoa cpf) {
		if(cpf == null 
				|| cpf.getCpf().length() != 11
				|| cpf.getCpf().isEmpty()) {
			
			mensagem = "CPF deve possuir tamanho 11 e somente números";
			return false;
		}
		return true;
	} 
	
	private boolean validarSexo(Pessoa pessoa) {
		if(pessoa.getSexo() == null 
				|| pessoa.getSexo().isEmpty()) {
			mensagem = "Deve preencher o compo sexo";
		return false;
		}
	return true;
	}
}