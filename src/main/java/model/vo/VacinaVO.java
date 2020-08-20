package model.vo;

public class VacinaVO {
		
	private int idVacina;
	private String paisOrigem;
	private int estagioPesquisa;
	private String dtInicioPesquisa;
	private PesquisadorVO pesquisador;
	
	public VacinaVO(int idVacina, String paisOrigem, int estagioPesquisa, String dtInicioPesquisa,
			PesquisadorVO pesquisador) {
		super();
		this.idVacina = idVacina;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.dtInicioPesquisa = dtInicioPesquisa;
		this.pesquisador = pesquisador;
	}
	
	public VacinaVO() {
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

	public PesquisadorVO getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(PesquisadorVO pesquisador) {
		this.pesquisador = pesquisador;
	}
	
}
