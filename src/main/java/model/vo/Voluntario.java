package model.vo;

public class Voluntario extends Pessoa{

	public Voluntario(int idPessoa, String nome, String dataNascimento, char sexo, String cpf) {
		super(idPessoa, nome, dataNascimento, sexo, cpf);
		
	}
	
	public Voluntario() {
		super();
		
	}
}
