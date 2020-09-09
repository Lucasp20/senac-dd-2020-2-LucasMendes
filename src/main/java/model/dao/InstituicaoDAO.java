package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.Instituicao;

public class InstituicaoDAO {

	public static int inserir(Instituicao instituicao) {
		Connection conexao = Banco.getConnection();
		Statement stmt = Banco.getStatement(conexao);
		int resultado = 0;
		
		String query = "INSERT INTO INSTITUICAO VALUES (NULL, '"
				+ instituicao.getNome() + "', '"
				+ instituicao.getRua() + "', '"
				+ instituicao.getBairro() + "', '"
				+ instituicao.getCidade() + "', '"
				+ instituicao.getEstado() + "', "
				+ instituicao.getCnpj() + " ) ";
		
		try {	
			resultado = stmt.executeUpdate(query);
					
	} catch (SQLException e) {
		System.out.println("Erro ao inserir instituicao. \nCausa: " + e.getMessage());
	}finally {
		Banco.closeStatement(stmt);
		Banco.closeConnection(conexao);
	}
	
	return resultado;
	}
}