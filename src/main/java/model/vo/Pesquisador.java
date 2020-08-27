package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pesquisador extends Pessoa {
	
	private Instituicao instituicao;

	public Pesquisador(int idPessoa, String nome, LocalDate dataNascimento, int sexo, String cpf, int reacao,
			LocalDate dataVacinacao, boolean voluntario, Instituicao instituicao) {
		super(idPessoa, nome, dataNascimento, sexo, cpf, reacao, dataVacinacao, voluntario);
		this.instituicao = instituicao;
	}

	
	public Pesquisador() {
		super();
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	
}