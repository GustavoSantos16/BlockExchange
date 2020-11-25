package br.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unip.banco.ConexaoSqlServer;
import br.unip.model.Criptomoeda;

public class CriptomoedaDAO {
	
	private Connection con = ConexaoSqlServer.getConexao();
	

	public void editar(Criptomoeda criptomoeda){
		String sql = "UPDATE criptomoeda "+
					"SET valor = ?, taxa = ? WHERE nome = ? ";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setDouble(1, criptomoeda.getValor());
			stm.setInt(2, criptomoeda.getTaxa());
			stm.setString(3, criptomoeda.getNome());
			
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

	public ArrayList<Criptomoeda> exibirCriptomoedas(){
		ArrayList <Criptomoeda> criptomoedas = new ArrayList<>();
		
		String sql = "select * from criptomoeda";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Criptomoeda cripto = new Criptomoeda();
				
				cripto.setId(rs.getInt("id"));
				cripto.setNome(rs.getString("nome"));
				cripto.setValor(rs.getDouble("valor"));
				cripto.setTaxa(rs.getInt("taxa"));
				
				criptomoedas.add(cripto);
			}
			
			ConexaoSqlServer.fecharConexao();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return criptomoedas;
		
	}
	
	public Criptomoeda getCriptoByName(String nome){
		Criptomoeda criptomoeda = new Criptomoeda();
		
		String sql = "SELECT * FROM criptomoeda WHERE nome = ?";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, nome);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				criptomoeda.setId(rs.getInt("id"));
				criptomoeda.setNome(rs.getString("nome"));
				criptomoeda.setValor(rs.getDouble("valor"));
				criptomoeda.setTaxa(rs.getInt("taxa"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConexaoSqlServer.fecharConexao();
		
		return criptomoeda;
		
	}
}
