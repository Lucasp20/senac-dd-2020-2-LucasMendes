package model.vo;

public class Pesquisador extends Pessoa {

	private Instituicao instituicao;

	public Pesquisador(int idPessoa, String nome, String dataNascimento, char sexo, String cpf,
			Instituicao instituicao) {
		super(idPessoa, nome, dataNascimento, sexo, cpf);
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
