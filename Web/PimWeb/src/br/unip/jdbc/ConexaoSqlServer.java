package br.unip.jdbc;

import java.sql.*;

public class ConexaoSqlServer {
	private static Connection con = null;
	
	public static Connection abrirConexao(){
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
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
