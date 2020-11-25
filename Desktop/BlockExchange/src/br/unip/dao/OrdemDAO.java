package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.unip.banco.ConexaoSqlServer;
import br.unip.model.Ordem;

public class OrdemDAO {

public ArrayList<Ordem> listaOrdens(){		
		
		ArrayList<Ordem> lista = new ArrayList<>();
		Ordem ordem = null;
		
		Connection con = ConexaoSqlServer.getConexao();
		
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
}
