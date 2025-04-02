package edu.desafiopoo;

public abstract class Conta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo += saldo;
	}

	@Override
	public String toString() {
		return "\nAgência = " + agencia + "\nNumero da Conta = " + numero + "\nTipo de Conta = "
				+ getClass().getSimpleName() + String.format("\nSaldo = %.2f", saldo) + "\nTitular = "
				+ cliente.getNome() + " " + "(" + cliente.getCpf() + ")";
	}

	public boolean sacar(double valor) {
		if (valor > 0 && saldo >= valor) {
			saldo -= valor;
			System.out.println("Saque de R$" + valor + " realizado com sucesso!");
			return true;
		}
		System.out.println("Saldo insuficiente ou valor inválido.");
		return false;
	}

	public boolean depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			System.out.println("Operação realizada com sucesso! \n");
			return true;
		}
		System.out.println("Valor inválido! ");
		return false;
	}

	public boolean transferir(Conta destino, double valor) {
		if (valor > 0 && saldo >= valor) {
			this.saldo -= valor;
			destino.setSaldo(valor);
			System.out.println("Operação realizada com sucesso! \n");
			return true;
		}
		System.out.println("Saldo insuficiente ou valor inválido.");
		return false;
	}

}
