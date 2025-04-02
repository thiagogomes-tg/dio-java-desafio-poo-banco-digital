package edu.desafiopoo;

public class ContaPoupanca extends Conta {

	private double rendimento;

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		this.rendimento = 0.10;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("\nRendimento = %.2f%%", rendimento * 100);
	}

}
