package model.vo;

public class Vacina {
		
	private int idVacina;
	private String paisOrigem;
	private int estagioPesquisa;
	private String dtInicioPesquisa;
	private Pesquisador pesquisador;
	
	public Vacina(int idVacina, String paisOrigem, int estagioPesquisa, String dtInicioPesquisa,
			Pesquisador pesquisador) {
		super();
		this.idVacina = idVacina;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.dtInicioPesquisa = dtInicioPesquisa;
		this.pesquisador = pesquisador;
	}
	
	public Vacina() {
		super();
		
	}

	public int getIdVacina() {
		return idVacina;
	}

	public void setIdVacina(int idVacina) {
		this.idVacina = idVacina;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public int getEstagioPesquisa() {
		return estagioPesquisa;
	}

	public void setEstagioPesquisa(int estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}

	public String getDtInicioPesquisa() {
		return dtInicioPesquisa;
	}

	public void setDtInicioPesquisa(String dtInicioPesquisa) {
		this.dtInicioPesquisa = dtInicioPesquisa;
	}

	public Pesquisador getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(Pesquisador pesquisador) {
		this.pesquisador = pesquisador;
	}
	
}
