package model.vo;

public class VoluntarioVO extends PessoaVO{

	public VoluntarioVO(int idPessoa, String nome, String dataNascimento, char sexo, String cpf) {
		super(idPessoa, nome, dataNascimento, sexo, cpf);
		
	}
	
	public VoluntarioVO() {
		super();
		
	}
}
