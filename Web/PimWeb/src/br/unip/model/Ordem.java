package br.unip.model;

public class Ordem {
	private int id;
	private int usuario_id;
	private int cripto_id;
	private String tipo;
	private String data;
	private String Status;
	private double preco;
	private double quantidade;
	private String criptoname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	public int getCripto_id() {
		return cripto_id;
	}
	public void setCripto_id(int cripto_id) {
		this.cripto_id = cripto_id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getCriptoname() {
		return criptoname;
	}
	public void setCriptoname(String criptoname) {
		this.criptoname = criptoname;
	}
}
