package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import br.unip.banco.ConexaoSqlServer;
import br.unip.model.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoSqlServer.getConexao();
	
	
	public void moderar(String status, int id){
		String sql = "UPDATE usuario "+
					"SET status = ? WHERE id = ? ";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, status);
			stm.setInt(2, id);
			
			if(stm.execute()){
				JOptionPane.showMessageDialog(null, "Não foi possivel editar!");
			}else{
				JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
			}
			ConexaoSqlServer.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Usuario getUserByCpf(String cpf){
		Usuario user = new Usuario();
		
		String sql = "SELECT * FROM usuario WHERE cpf = ?";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cpf);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				user.setId(rs.getInt("id"));
				user.setFoto(rs.getString("foto"));
				user.setNome(rs.getString("nome"));
				user.setEmail(rs.getString("email"));
				user.setCpf(rs.getString("cpf"));
				user.setRg(rs.getString("rg"));
				user.setData_nascimento(rs.getString("data_nascimento"));
				user.setStatus(rs.getString("status"));
				user.setCelular(rs.getString("celular"));
				user.setSaldo(rs.getDouble("saldo"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConexaoSqlServer.fecharConexao();
		
		return user;
		
	}
	
	public ArrayList<Usuario> exibirUsuarios(){
		ArrayList <Usuario> usuarios = new ArrayList<>();
		
		String sql = "select * from usuario";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Usuario user = new Usuario();
				
				user.setId(rs.getInt("id"));
				user.setFoto(rs.getString("foto"));
				user.setNome(rs.getString("nome"));
				user.setEmail(rs.getString("email"));
				user.setCpf(rs.getString("cpf"));
				user.setRg(rs.getString("rg"));
				user.setData_nascimento(rs.getString("data_nascimento"));
				user.setStatus(rs.getString("status"));
				user.setCelular(rs.getString("celular"));
				user.setSaldo(rs.getDouble("saldo"));
				
				usuarios.add(user);
			}
			
			ConexaoSqlServer.fecharConexao();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarios;
		
	}

}
