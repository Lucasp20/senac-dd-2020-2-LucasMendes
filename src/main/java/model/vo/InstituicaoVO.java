package model.vo;

public class InstituicaoVO {
	
	private String nome;
	private String cnpj;
	private EnderecoVO endereco;
	
	public InstituicaoVO(String nome, String cnpj, EnderecoVO endereco) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}
	
	public InstituicaoVO() {
		super();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public EnderecoVO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}
	
	
	
}
