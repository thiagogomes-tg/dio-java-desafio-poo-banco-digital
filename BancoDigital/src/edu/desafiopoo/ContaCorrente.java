package edu.desafiopoo;

public class ContaCorrente extends Conta {
	
	private double limiteConta;
	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
		this.limiteConta = 600;
	}

	public double getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(double limiteConta) {
		this.limiteConta = limiteConta;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("\nLimite da Conta = %.2f " , limiteConta);
	}
	
	@Override
    public boolean sacar(double valor) {
        if (valor > 0 && saldo+limiteConta >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
            return true;
        }
        System.out.println("Saldo insuficiente ou valor inválido.");
        return false;
    }
	
}
