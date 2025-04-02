package edu.desafiopoo;

public class Cliente {

	// Somente nome não como final, pois pode haver mudança de sobrenome
	private String nome;
	private final String cpf;
	private final int anoNascimento;

	public Cliente(String nome, String cpf, int anoNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.anoNascimento = anoNascimento;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
