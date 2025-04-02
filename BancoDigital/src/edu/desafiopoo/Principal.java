package edu.desafiopoo;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		Banco banco1 = new Banco("Bradesco");
		
		while (true) {
			System.out.println("MENU");
			System.out.println("1 - Criar conta ");
			System.out.println("2 - Listar contas ");
			System.out.println("3 - Sacar ");
			System.out.println("4 - Depositar ");
			System.out.println("5 - Transferir ");
			System.out.println("0 - Sair ");
			
			int opcao = scanner.nextInt();
			
			if(opcao == 0) {
				System.out.println("\nEncerrando... ");
				break;
			}
			
			else if(opcao == 1){
				System.out.println("\nFavor inserir nome, CPF e ano de nascimento. ");
				System.out.println("Nome: ");
				scanner.nextLine();
				String nome = scanner.nextLine();
				
				System.out.println("CPF: ");
				String cpf = scanner.nextLine();
				
				System.out.println("Ano de nascimento: ");
				int anoNascimento = scanner.nextInt();
				
				System.out.println("\nEscolha o tipo de conta:");
				System.out.println("1 - Conta Corrente ");
				System.out.println("2 - Conta Poupança ");
				int tipoConta = scanner.nextInt();
				
				if(banco1.adicionarConta(nome, cpf, anoNascimento, tipoConta)) {
					System.out.println("Operação realizada com sucesso! \n");
				}
			}
			
			else if(opcao == 2) {
				while (true){
					banco1.listarContas();
					System.out.println("\nInsira qualquer caractere para voltar ao Menu. ");
					String voltar = scanner.next();
					if(voltar != null) {
						break;
					}
				}
			}
			
			else if(opcao == 3) {
				System.out.println("\nFavor informar número da conta: ");
				String numeroConta = scanner.next();
				System.out.println("Favor informar valor para saque: ");
				double valor = scanner.nextDouble();
				banco1.sacarDeConta(numeroConta, valor);			
			}
			
			else if(opcao == 4){
				System.out.println("\nFavor informar número da conta: ");
				String numeroConta = scanner.next();
				System.out.println("Favor informar valor para deposito: ");
				double valor = scanner.nextDouble();
				banco1.depositarEmConta(numeroConta, valor);
			}
			
			else if(opcao == 5){
				System.out.println("\nFavor informar número da sua conta e da conta de destino: ");
				System.out.println("Sua conta: ");
				String numeroConta = scanner.next();
				
				System.out.println("Conta de destino: ");
				String numeroContaDestino = scanner.next();

				System.out.println("Favor informar valor para transferência: ");
				double valor = scanner.nextDouble();
				banco1.transferirEntreContas(numeroConta, numeroContaDestino, valor);
			}
			else {
				System.out.println("Opção inválida! ");
			}
		}
		
		scanner.close();
	}

}
