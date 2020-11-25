package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unip.jdbc.ConexaoSqlServer;
import br.unip.model.Usuario;



public class UsuarioDAO {
	
	public Usuario autenticar(String email, String senha) {
		Usuario u = null;
		String sql = "SELECT * FROM usuario " 
				+ "WHERE email = ? AND senha = ? AND status = 1";

		try {
			PreparedStatement stm = ConexaoSqlServer.abrirConexao().prepareStatement(sql);
			
			stm.setString(1, email);
			stm.setString(2, senha);
 
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				
				u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setCpf(rs.getString("cpf"));
				u.setRg(rs.getString("rg"));
				u.setCelular(rs.getString("celular"));
				u.setData_nascimento(rs.getString("data_nascimento"));
				u.setSaldo(rs.getDouble("saldo"));
				u.setSenha(rs.getString("senha"));
			
			}

			ConexaoSqlServer.fecharConexao();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public void gravar(Usuario usuario){

		Connection con = ConexaoSqlServer.abrirConexao();
		
		String sql = "INSERT INTO usuario "
				+ "(nome, email, cpf, rg, celular, data_nascimento, senha, status) "
				+ "values (?, ?, ?, ?, ?, ?, ?, 1)";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getCpf());
			stm.setString(4, usuario.getRg());
			stm.setString(5, usuario.getCelular());
			stm.setString(6, usuario.getData_nascimento());
			stm.setString(7, usuario.getSenha());
		
			stm.execute();
			
			ConexaoSqlServer.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(Usuario usuario){

		Connection con = ConexaoSqlServer.abrirConexao();
		
		String sql = "UPDATE usuario set nome = ?, email = ?, cpf = ?, rg = ?, celular = ?, data_nascimento = ?, senha = ? WHERE id = ?";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getCpf());
			stm.setString(4, usuario.getRg());
			stm.setString(5, usuario.getCelular());
			stm.setString(6, usuario.getData_nascimento());
			stm.setString(7, usuario.getSenha());
			stm.setInt(8, usuario.getId());
		
			stm.execute();
			
			ConexaoSqlServer.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void editar(String cpf, Double valor ){

		Connection con = ConexaoSqlServer.abrirConexao();
		
		String sql = "UPDATE usuario set saldo = ? WHERE cpf = ?";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDouble(1, valor);
			stm.setString(2, cpf);
		
			stm.execute();
			
			ConexaoSqlServer.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
