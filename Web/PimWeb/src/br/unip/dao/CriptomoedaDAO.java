package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.unip.jdbc.ConexaoSqlServer;
import br.unip.model.Criptomoeda;


public class CriptomoedaDAO {
	
	public ArrayList<Criptomoeda> listaCriptomoedas(){		
		
		ArrayList<Criptomoeda> lista = new ArrayList<>();
		Criptomoeda criptomoeda = null;
		
		Connection con = ConexaoSqlServer.abrirConexao();
		
		String sql = "SELECT * FROM criptomoeda";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				
				criptomoeda = new Criptomoeda();
				
				criptomoeda.setId(rs.getInt("id"));
				criptomoeda.setNome(rs.getString("nome"));
				criptomoeda.setValor(rs.getDouble("valor"));
				criptomoeda.setTaxa(rs.getInt("taxa"));
		
				lista.add(criptomoeda);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConexaoSqlServer.fecharConexao();
		
		return lista;
	}
	
	

}
