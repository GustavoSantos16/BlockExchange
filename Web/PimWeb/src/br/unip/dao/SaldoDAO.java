package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.unip.jdbc.ConexaoSqlServer;
import br.unip.model.Saldo;

public class SaldoDAO {
	
	public ArrayList<Saldo> listarMeusSaldos(Integer usuario_id){		
		
		ArrayList<Saldo> lista = new ArrayList<>();
		Saldo saldo = null;
		
		Connection con = ConexaoSqlServer.abrirConexao();
		
		String sql ="select a.id,a.nome, sum(b.preco) as valor_investido, sum(b.quantidade) as quantidade from criptomoeda as a" + 
				" inner join ordem as b on b.id_criptomoeda = a.id where b.id_usuario ="+usuario_id+ 
				" group by a.nome, b.preco, a.id order by a.id";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				
				saldo = new Saldo();
				
				saldo.setId(rs.getInt("id"));
				saldo.setNome(rs.getString("nome"));
				saldo.setValor_investido(rs.getDouble("valor_investido"));
				saldo.setQuantidade(rs.getDouble("quantidade"));
		
				lista.add(saldo);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConexaoSqlServer.fecharConexao();
		
		return lista;
	}

}
