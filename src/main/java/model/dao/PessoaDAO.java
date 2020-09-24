package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.vo.Pessoa;


public class PessoaDAO {
	
		
		public int inserir(Pessoa pessoa) {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			int resultado = 0;
			
					String query = "INSERT INTO `pessoa` VALUES (NULL, '"
							+ pessoa.getNome() +"', '"
							+ pessoa.getDataNascimento() +"', '"
							+ pessoa.getSexo() +"', '"
							+ pessoa.getCpf() + "', '"
							+ pessoa.getReacao() + "', '"
							+ pessoa.getDataVacinacao() + "', "
							+ pessoa.isVoluntario() + " ) ";
			try {
				resultado = stmt.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("Erro ao executar a query de cadastro.");
				System.out.println("Erro: " + e.getMessage());
			} finally {
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
		
			return resultado;
		}
		
		public boolean excluir(int idPessoa) {
			Connection conexao = Banco.getConnection();
			
			String sql = "DELETE FROM pessoa WHERE idPessoa = " + idPessoa;

			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
			boolean excluiu = false;
				
			try {
								
				int codigoRetorno = query.executeUpdate();
				excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
			} catch (SQLException e) {
				System.out.println("Erro ao excluir Pessoa (id: " + idPessoa + ") .\nCausa: " + e.getMessage());
			}finally {
				Banco.closeStatement(query);
				Banco.closeConnection(conexao);
			}
					
			return excluiu;
		}
		
		public boolean alterar(Pessoa pessoa) {
			String sql = " UPDATE PESSOA "
					+ " SET NOME=? , DataNascimento=?, sexo=?, reacao=? , dataVacinacao=? , voluntario=?"
					+ "	where IDUSUARIO=? ";
					
			boolean alterou = false;
						
			try (Connection conexao = Banco.getConnection();
				PreparedStatement query = Banco.getPreparedStatement(conexao, sql);) {
				query.setString(1, pessoa.getNome());
				query.setString(2,pessoa.getSexo());
				query.setInt(3,pessoa.getReacao());
				query.setBoolean(4, pessoa.isVoluntario());
				
				Date dataNascimentoConvertidaParaSQL = java.sql.Date.valueOf(pessoa.getDataNascimento());
				query.setDate(5, dataNascimentoConvertidaParaSQL);
				
				Date dataVacinacaoConvertidaParaSQL = java.sql.Date.valueOf(pessoa.getDataVacinacao());
				query.setDate(6, dataVacinacaoConvertidaParaSQL);
				
				int codigoRetorno = query.executeUpdate();
				alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
			} catch (SQLException e) {
				System.out.println("Erro ao alterar pessoa.\nCausa: " + e.getMessage());
			}
					
			return alterou;
		}
			
		public static Pessoa pesquisarPorId(int id) {
			String sql = "SELECT * FROM PESSOA WHERE IDPESSOA=? ";
			Pessoa pesquisaId = null;
			
			try (Connection conexao = Banco.getConnection();
					PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
					consulta.setInt(1,id);
					ResultSet conjuntoResultante = consulta.executeQuery();
			} catch (SQLException e) {
				System.out.println("Erro ao consultar pessoa por id (id: " + id + ") \nCausa: " + e.getMessage());
			}
			
			return pesquisaId;
		}
		
		public static List<Pessoa> pesquisarTodos() {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			ResultSet resultado = null;
			ArrayList<Pessoa> pesquisaTodos = new ArrayList<Pessoa>();
			
			String query = "SELECT idpessoa, nome, DATA_NASCIMENTO, sexo, cpf, reacao, data_vacinacao, voluntario FROM pessoa ";
			
			
			try {
				resultado = stmt.executeQuery(query);
				while (resultado.next()) {
					Pessoa pessoa = new Pessoa();
					pessoa.setIdPessoa(Integer.parseInt(resultado.getString(1)));
					pessoa.setNome(resultado.getNString(2));
					pessoa.setDataNascimento(LocalDate.parse(resultado.getString(3)));
					pessoa.setSexo(resultado.getString(4));
					pessoa.setCpf(resultado.getString(5));
					pessoa.setReacao(Integer.parseInt(resultado.getString(6)));
					pessoa.setDataVacinacao(LocalDate.parse(resultado.getString(7)));
					pessoa.setVoluntario(Boolean.parseBoolean(resultado.getString(8)));
					pesquisaTodos.add(pessoa);
				}
			} catch (SQLException e) {
				System.out.println("\n Erro ao executar a query de consulta de todos as Pessoas.");
				System.out.println("Erro: " + e.getMessage());
			} finally {
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
			
			return pesquisaTodos;
			
		}

		public boolean cpfJaCadastrado(Pessoa pessoa) {
			boolean jaCadastrado = false;

			Connection conexao = Banco.getConnection();
			String sql = "SELECT count(id) FROM PESSOA WHERE CPF = ?";
			
			if(pessoa.getIdPessoa() > 0) {
				sql += " AND ID <> ? ";
			}
			
			PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
			
			try {
				consulta.setString(1, pessoa.getCpf());
				
				if(pessoa.getIdPessoa() > 0) {
					consulta.setInt(2, pessoa.getIdPessoa());
				}
				
				ResultSet conjuntoResultante = consulta.executeQuery();
				jaCadastrado = conjuntoResultante.next();
			} catch (SQLException e) {
				System.out.println("Erro ao verificar se CPF (" + pessoa.getCpf() + ") já foi usado .\nCausa: " + e.getMessage());
			}finally {
				Banco.closeStatement(consulta);
				Banco.closeConnection(conexao);
			}
			
			return jaCadastrado;
		}
		
}

