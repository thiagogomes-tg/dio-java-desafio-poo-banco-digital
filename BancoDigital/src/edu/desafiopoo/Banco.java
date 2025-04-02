package edu.desafiopoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Banco {

	private final String nome;
	private final List<Conta> contas;
	
	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public List<Conta> getContas() {
	    return Collections.unmodifiableList(contas);
	}
	
	public boolean adicionarConta(String nome, String cpf, int anoNascimento, int tipoConta) {
		Conta conta = null;
		if (tipoConta == 1) {
			conta = new ContaCorrente(new Cliente(nome, cpf, anoNascimento));
			contas.add(conta);
			return true;
		} 
		else if (tipoConta == 2) {
			conta = new ContaPoupanca(new Cliente(nome, cpf, anoNascimento));
			contas.add(conta);
			return true;
		} else {
			System.out.println("\nTipo de conta inválido! ");
			return false;
		}
	}
	
	public void listarContas() {
		contas.forEach(System.out::println);
	}
	
    public boolean sacarDeConta(String numeroConta, double valor) {
        Optional<Conta> contaOptional = contas.stream()
        									 .filter(c -> String.valueOf(c.getNumero()).equals(numeroConta))
                                             .findFirst();

        return contaOptional.map(conta -> conta.sacar(valor))
                            .orElseGet(() -> {
                                System.out.println("Conta não encontrada!");
                                return false;
                            });
    }
    
    public boolean depositarEmConta(String numeroConta, double valor) {
        Optional<Conta> contaOptional = contas.stream()
                                              .filter(c -> String.valueOf(c.getNumero()).equals(numeroConta))
                                              .findFirst();

        return contaOptional.map(conta -> conta.depositar(valor))
                            .orElseGet(() -> {
                                System.out.println("Conta não encontrada!");
                                return false;
                            });
        
    }
    
    public boolean transferirEntreContas(String numeroOrigem, String numeroDestino, double valor) {
        Optional<Conta> contaOrigem = contas.stream()
                                            .filter(c -> String.valueOf(c.getNumero()).equals(numeroOrigem))
                                            .findFirst();

        Optional<Conta> contaDestino = contas.stream()
                                             .filter(c -> String.valueOf(c.getNumero()).equals(numeroDestino))
                                             .findFirst();

        if (contaOrigem.isPresent() && contaDestino.isPresent()) {
            return contaOrigem.get().transferir(contaDestino.get(), valor);
        } else {
            System.out.println("Conta de origem ou destino não encontrada!");
            return false;
        }
    }
    
}
