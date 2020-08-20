package model.vo;

public class PesquisadorVO extends PessoaVO {

	private InstituicaoVO instituicao;

	public PesquisadorVO(int idPessoa, String nome, String dataNascimento, char sexo, String cpf,
			InstituicaoVO instituicao) {
		super(idPessoa, nome, dataNascimento, sexo, cpf);
		this.instituicao = instituicao;
	}
	
	public PesquisadorVO() {
		super();
		
	}

	public InstituicaoVO getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoVO instituicao) {
		this.instituicao = instituicao;
	}
	
	
}
