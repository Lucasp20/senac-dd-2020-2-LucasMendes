package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
}

