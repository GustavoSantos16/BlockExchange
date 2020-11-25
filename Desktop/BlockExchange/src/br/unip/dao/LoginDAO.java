package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.unip.banco.ConexaoSqlServer;
import br.unip.model.Login;


public class LoginDAO {
	public boolean getLoginSenha(Login logar){
		boolean logado = false;
		
		Connection con = ConexaoSqlServer.getConexao();
		
		String sql = "SELECT * FROM funcionario WHERE email = ? AND senha = ?";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, logar.getEmail());
			stm.setString(2, logar.getSenha());
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				logar.setEmail(rs.getString("email"));
				logar.setSenha(rs.getString("senha"));
				logado = stm.execute();
			}

			if(logado == true){
				JOptionPane.showMessageDialog(null, "       Seja Bem Vindo !");
			}else{
				JOptionPane.showMessageDialog(null,"Usuario e/ou senha incorretos");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logado;
		
	}
}
