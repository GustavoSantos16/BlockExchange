package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.unip.jdbc.ConexaoSqlServer;
import br.unip.model.Ordem;

public class OrdemDAO {

	public void gravar(Ordem ordem){

		Connection con = ConexaoSqlServer.abrirConexao();
		
		String sql = "INSERT INTO ordem "
				+ "(tipo, quantidade, preco, status, id_usuario, id_criptomoeda)"
				+ "values (?, ?, ?, 1, ?, ?)";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, ordem.getTipo());
			stm.setDouble(2, ordem.getQuantidade());
			stm.setDouble(3, ordem.getPreco());
			stm.setInt(4, ordem.getUsuario_id());	
			stm.setInt(5, ordem.getCripto_id());
		
			stm.execute();
			
			ConexaoSqlServer.fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public ArrayList<Ordem> listaOrdem(){		
		
		ArrayList<Ordem> lista = new ArrayList<>();
		Ordem ordem = null;
		
		Connection con = ConexaoSqlServer.abrirConexao();
		
		String sql = "SELECT a.id, a.tipo, convert(CHAR,a.data_ordem,103) as data_ordem, a.quantidade, a.preco, b.nome as moeda FROM ordem as a INNER JOIN criptomoeda as b "
				+ "ON a.id_criptomoeda = b.id order by a.id desc";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				
				ordem = new Ordem();
				
				ordem.setId(rs.getInt("id"));
				ordem.setData(rs.getString("data_ordem"));
				ordem.setTipo(rs.getString("tipo"));
				ordem.setQuantidade(rs.getDouble("quantidade"));
				ordem.setPreco(rs.getDouble("preco"));
				ordem.setCriptoname(rs.getString("moeda"));
		
				lista.add(ordem);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConexaoSqlServer.fecharConexao();
		
		return lista;
	}


public ArrayList<Ordem> listarMinhasOrdens(Integer usuario_id){		
	
	ArrayList<Ordem> lista = new ArrayList<>();
	Ordem ordem = null;
	
	Connection con = ConexaoSqlServer.abrirConexao();
	
	String sql = "SELECT a.id, a.tipo, convert(CHAR,a.data_ordem,103) as data_ordem, a.quantidade, "
			+ "a.preco, b.nome as moeda FROM ordem as a INNER JOIN criptomoeda as b "
			+ "ON a.id_criptomoeda = b.id WHERE a.id_usuario = "+usuario_id+" order by a.id desc";
	
	try {
		PreparedStatement stm = con.prepareStatement(sql);
		
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			
			ordem = new Ordem();
			
			ordem.setId(rs.getInt("id"));
			ordem.setData(rs.getString("data_ordem"));
			ordem.setTipo(rs.getString("tipo"));
			ordem.setQuantidade(rs.getDouble("quantidade"));
			ordem.setPreco(rs.getDouble("preco"));
			ordem.setCriptoname(rs.getString("moeda"));
	
			lista.add(ordem);
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	ConexaoSqlServer.fecharConexao();
	
	return lista;
}
}
