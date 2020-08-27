package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pesquisador extends Pessoa {

	private Instituicao instituicao;

	public Pesquisador(DateTimeFormatter dataFormatter, int idPessoa, String nome, LocalDate dataNascimento, int sexo,
			String cpf, boolean voluntario, Instituicao instituicao) {
		super(dataFormatter, idPessoa, nome, dataNascimento, sexo, cpf, voluntario);
		this.instituicao = instituicao;
	}

	
	public Pesquisador() {
		super();
		
	}
	
}