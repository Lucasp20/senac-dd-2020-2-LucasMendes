package model.vo;

public class Voluntario extends Pessoa{

	

	public Voluntario(int idPessoa, String nome, String dataNascimento, char sexo, String cpf, int reacao,
			int tipoPessoa) {
		super(idPessoa, nome, dataNascimento, sexo, cpf, reacao, tipoPessoa);
		
	}
	
	public Voluntario() {
		super();
		
	}
	
	
}
