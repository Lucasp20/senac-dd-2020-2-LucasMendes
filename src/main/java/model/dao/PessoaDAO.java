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
import model.vo.Vacina;


public class PessoaDAO {
	
		
		public Pessoa inserir(Pessoa pessoa) {
			Connection conexao = Banco.getConnection();
			
			String sql = "INSERT INTO PESSOA (NOME, DATA_NASCIMENTO, SEXO, CPF, REACAO, DATA_VACINACAO, VOLUNTARIO) "
							+ "VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conexao, sql);
			
			try {
				query.setString(1, pessoa.getNome());
				query.setString(2, pessoa.getSexo());
				query.setString(3, pessoa.getCpf());
				query.setInt(4, pessoa.getReacao());
				query.setBoolean(5, pessoa.isVoluntario());
				
				Date dataNascimentoConvertidaParaSQL = java.sql.Date.valueOf(pessoa.getDataNascimento());
				query.setDate(6,dataNascimentoConvertidaParaSQL);
				
				Date dataVacinacaoConvertidaParaSQL = java.sql.Date.valueOf(pessoa.getDataVacinacao());
				query.setDate(7, dataVacinacaoConvertidaParaSQL);
				
				int codigoRetorno = query.executeUpdate();
				if(codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
					ResultSet resultado = query.getGeneratedKeys();
					int chaveGerada = resultado.getInt(1);
					
					pessoa.setIdPessoa(chaveGerada);
				}
				
			} catch (SQLException e) {
				System.out.println("Erro ao inserir pessoa.\nCausa: " + e.getMessage());
			}finally {
				Banco.closeStatement(query);
				Banco.closeConnection(conexao);
			}
					
			return pessoa;
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
					+ " SET NOME=? , DataNascimento=?, sexo=?, cpf=?, reacao=? , dataVacinacao=? , voluntario=?"
					+ "	where IDUSUARIO=? ";
					
			boolean alterou = false;
						
			try (Connection conexao = Banco.getConnection();
				PreparedStatement query = Banco.getPreparedStatement(conexao, sql);) {
				query.setString(1, pessoa.getNome());
				query.setString(2,pessoa.getSexo());
				query.setNString(3, pessoa.getCpf());
				query.setInt(4,pessoa.getReacao());
				query.setBoolean(5, pessoa.isVoluntario());
				
				Date dataNascimentoConvertidaParaSQL = java.sql.Date.valueOf(pessoa.getDataNascimento());
				query.setDate(6, dataNascimentoConvertidaParaSQL);
				
				Date dataVacinacaoConvertidaParaSQL = java.sql.Date.valueOf(pessoa.getDataVacinacao());
				query.setDate(7, dataVacinacaoConvertidaParaSQL);
				
				int codigoRetorno = query.executeUpdate();
				alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
			} catch (SQLException e) {
				System.out.println("Erro ao alterar pessoa.\nCausa: " + e.getMessage());
			}
					
			return alterou;
		}
			
		public Pessoa pesquisarPorId(int id) {
			String sql = " SELECT * FROM PESSOA WHERE ID=? ";
			Pessoa pessoaBuscada = null;
			
			try (Connection conexao = Banco.getConnection();
				PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
				consulta.setInt(1, id);
				ResultSet conjuntoResultante = consulta.executeQuery();
				
				if(conjuntoResultante.next()) {
					pessoaBuscada = construirPessoaDoResultSet(conjuntoResultante);
				}
			} catch (SQLException e) {
				System.out.println("Erro ao consultar pessoa por Id (id: " + id + ") .\nCausa: " + e.getMessage());
			}
			
			return pessoaBuscada;	
		}
		

		public static List<Pessoa> pesquisarTodos() {
			Connection conexao = Banco.getConnection();
			String sql = "SQL * FROM PESSOA ";
			
			PreparedStatement consulta = Banco.getPreparedStatement(conexao,  sql);
			List<Pessoa> pessoasBuscadas = new ArrayList<Pessoa>();
			
			
			try { 
				ResultSet conjuntoResultante = consulta.executeQuery();
				while(conjuntoResultante.next()) {
				Pessoa pessoaBuscada = construirPessoaDoResultSet(conjuntoResultante);					
				pessoasBuscadas.add(pessoaBuscada);
				}
			} catch (SQLException e) {
				System.out.println("Erro ao consultar todos as pessoas .\nCausa: " + e.getMessage());
			}finally {			
				Banco.closeStatement(consulta);			
				Banco.closeConnection(conexao);
			}	
				return pessoasBuscadas;
		}
		
		private static Pessoa construirPessoaDoResultSet(ResultSet conjuntoResultante) throws SQLException {
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(conjuntoResultante.getInt("id"));
			pessoa.setNome(conjuntoResultante.getString("nome"));
			pessoa.setSexo(conjuntoResultante.getString("sexo"));
			pessoa.setCpf(conjuntoResultante.getString("cpf"));
			pessoa.setVoluntario(conjuntoResultante.getBoolean("isVoluntario"));
			
			Date dataNasci = conjuntoResultante.getDate("data_nascimento");
			LocalDate dataNascimento = dataNasci.toLocalDate();
			pessoa.setDataNascimento(dataNascimento);
			
			Date dataVacina = conjuntoResultante.getDate("data_nascimento");
			LocalDate dataVacinacao = dataVacina.toLocalDate();
			pessoa.setDataNascimento(dataNascimento);
			
			return pessoa;
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

