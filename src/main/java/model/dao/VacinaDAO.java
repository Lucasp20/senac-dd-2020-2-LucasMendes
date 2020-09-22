package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.vo.Instituicao;
import model.vo.Pesquisador;
import model.vo.Vacina;

public class VacinaDAO {

	public Vacina inserir(Vacina vacina) {
		Connection conexao = Banco.getConnection();
		
		String sql = " INSERT INTO VACINA (PAIS_DE_ORIGEM, ESTAGIO_PESQUISA, DATA_INICIO_PESAQUISA, IDPESQUISADOR) " 
					+ " VALUES (?,?,?,?) ";
		
		PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conexao, sql);

		try {
			
			Pesquisador nomePesquisador = verificarNomeDoPesquisador(vacina);
						
			query.setString(1, vacina.getPaisOrigem());
			query.setInt(2, vacina.getEstagioPesquisa());
			query.setInt(3, nomePesquisador.getIdPessoa());
			
			Date dataInicioPesquisaConvertidaParaSQL = java.sql.Date.valueOf(vacina.getDataInicioPesquisa());
			query.setDate(5, dataInicioPesquisaConvertidaParaSQL);
			
			int codigoRetorno = query.executeUpdate();
			if(codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet resultado = query.getGeneratedKeys();
				int chaveGerada = resultado.getInt(1);
				
				vacina.setIdVacina(chaveGerada);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir pessoa.\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}
				
		return vacina;
	}

	public int excluir(int idVacina) {
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM CLIENTE WHERE idVacina=? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		int excluiu = 0;
		
		try {
			query.setInt(1, idVacina);
			
			int codigoRetorno = query.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir vacina (id: " + idVacina + ") .\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}
				
		return excluiu;
	}

	public boolean alterar (Vacina vacina) {
			String sql = "UPDATE VACINA " 
							+ "SET PAIS_DE_ORIGEM=?, ESTAGIO_PESQUISA=?, DATA_INICIO_PESAQUISA=?, IDPESQUISADOR=?"
							+ "WHERE idVacina=? ";
			
			boolean alterou = false;
			
			Pesquisador nomePesquisador = verificarNomeDoPesquisador(vacina);
			
			try (Connection conexao = Banco.getConnection();
				PreparedStatement query = Banco.getPreparedStatement(conexao, sql);) {
				query.setString(1, vacina.getPaisOrigem());
				query.setInt(2, vacina.getEstagioPesquisa());
				query.setInt(3, nomePesquisador.getIdPessoa());
				query.setInt(5,  vacina.getIdVacina());
				
				Date dataInicioPesquisaConvertidaParaSQL = java.sql.Date.valueOf(vacina.getDataInicioPesquisa());
				query.setDate(5, dataInicioPesquisaConvertidaParaSQL);
				
				int codigoRetorno = query.executeUpdate();
				alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
			} catch (SQLException e) {
				System.out.println("Erro ao alterar vacina. \nCausa: " + e.getMessage());
			}
					
			return alterou;
		}
	
	public static Vacina pesquisarPorId(int id) {

	return null;
	}
	
	public static List<Vacina> pesquisarTodos() {

	return null;
	}
	
	private Pesquisador verificarNomeDoPesquisador(Vacina vacina) {
		
		return null;
	}
	
}
