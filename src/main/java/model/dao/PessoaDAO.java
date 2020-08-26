package model.dao;

import java.sql.Connection;
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
							+ pessoa.getDataNascimento() +"', "
							+ pessoa.getSexo() +", '"
							+ pessoa.getCpf() +"', "
							+ pessoa.getReacao() + ",'"
							+ pessoa.getTipoPessoa() + "') ";
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
}

