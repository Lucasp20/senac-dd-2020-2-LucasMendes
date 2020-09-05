package model.dao;

import java.sql.Connection;
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
	
		
		public static int inserir(Pessoa pessoa) {
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
		
		public static int excluir(int idPessoa) {
			Connection conexao = Banco.getConnection();
			
			String sql = "DELETE FROM pessoa WHERE idPessoa = " + idPessoa;

			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
			int resultado = 0;
				
			try {
								
				int codigoRetorno = query.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("Erro ao excluir Pessoa (id: " + idPessoa + ") .\nCausa: " + e.getMessage());
			}finally {
				Banco.closeStatement(query);
				Banco.closeConnection(conexao);
			}
					
			return resultado;
		}
		
		public static int alterar(Pessoa pessoa) {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			int resultado = 0;
				
			String query = "UPDATE pessoa SET nome = '" + pessoa.getNome()
							+ "', DataNascimento = '" + pessoa.getDataNascimento()
							+ "', sexo = '" + pessoa.getSexo()
							+ "', cpf = '" + pessoa.getCpf()
							+ "', reacao = '" + pessoa.getReacao()
							+ "', dataVacinacao = '" + pessoa.getDataVacinacao()
							+ "', voluntario = '" + pessoa.isVoluntario()
							+ "' WHERE idusuario = " + pessoa.getIdPessoa();
			
			try {
			resultado = stmt.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("Erro ao executar a query de atualização da pessoa");
				System.out.println("Erro: " + e.getMessage());
			} finally {
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
			return resultado;
		}
			
		public Pessoa pesquisarPorId(int id) {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			Pessoa pesquisaId = null;
			
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
		
}

