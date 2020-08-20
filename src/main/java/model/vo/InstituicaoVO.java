package model.vo;

public class InstituicaoVO {
	
	private String nome;
	private String cnpj;
	
	
	public InstituicaoVO(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
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
	
}
