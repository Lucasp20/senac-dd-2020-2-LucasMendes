package model.vo;

public class Pessoa {

	private int idPessoa;
	private String nome;
	private String dataNascimento;
	private char sexo;
	private String cpf;
	private int tipoPessoa;
	
	public Pessoa(int idPessoa, String nome, String dataNascimento, char sexo, String cpf) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		
	}
	public Pessoa() {
		super();
		
	}
	
	public int getIdUsuario() {
		return idPessoa;
	}
	public void setIdUsuario(int idUsuario) {
		this.idPessoa = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
