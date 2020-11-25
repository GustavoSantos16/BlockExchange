package br.unip.model;

public class Saldo {
	private int id;
	private String nome;
	private double valor_investido;
	private double quantidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor_investido() {
		return valor_investido;
	}
	public void setValor_investido(double valor_investido) {
		this.valor_investido = valor_investido;
	}
	
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
