package br.unip.model;

public class Criptomoeda {

	private int id;
	private String nome;
	private double valor;
	private int taxa;
	
	
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getTaxa() {
		return taxa;
	}
	public void setTaxa(int taxa) {
		this.taxa = taxa;
	}
	
	
}
