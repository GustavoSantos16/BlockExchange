package br.unip.banco;

import java.sql.*;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConexaoSqlServer {

	private static Connection con = null;
	
	public static Connection getConexao(){
		String URL =  "jdbc:sqlserver://localhost:1433;databaseName=blockexchange";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			
			con = DriverManager.getConnection(URL,"sa","123456");
			
			System.out.println("Conexão aberta com sucesso!");
			
		}
		catch(SQLException ex) {
			System.out.println(""+ ex.getMessage());
		}
		
		catch(Exception e) {
			System.out.println("Não foi possivel conectar ao banco"+ e);
		}
	
		return con;
		
	}
	public static void fecharConexao(){
		try {
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro na tentativa de fechar o banco!",
					"Erro",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}





//conn = DriverManager.getConnection(URL);                      

//Executa pedido SQL
//query = conn.createStatement();
