package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Voluntario extends Pessoa{

	public Voluntario() {
		super();
		
	}

	public Voluntario(DateTimeFormatter dataFormatter, int idPessoa, String nome, LocalDate dataNascimento, int sexo,
			String cpf, boolean voluntario) {
		super(dataFormatter, idPessoa, nome, dataNascimento, sexo, cpf, voluntario);
		
	}

	

}