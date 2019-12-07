package br.com.bahia.bancos.modelo;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import java.math.BigDecimal;

public class Client 
{
	public static void main(String[] args)
	{
		try
		{
			Banco b = (Banco) Naming.lookup("//192.168.0.13:1080/Banco");
			Scanner sc1 = new Scanner(System.in);
			System.out.println("-------------- BAHIA BANCO --------------\n");
			System.out.println("| Usuário:");
			String n_conta = sc1.nextLine();
			System.out.println("| Senha:");
			String senha = sc1.nextLine();
			//System.out.println(b.acessar_conta("1234", "00001"));
			if(b.acessar_conta(senha, n_conta)) {
				System.out.println("Conta acessada");
				int opcao = 0;
				do {
					if(b.acessar_conta(senha,n_conta)) {
						System.out.println("-------------- BAHIA BANCO --------------\n");
						System.out.println("---------------- OPÇÕES -----------------\n");
						System.out.println("1 - SACAR");
						System.out.println("2 - DEPOSITAR");
						System.out.println("3 - TRANSFERÊNCIA");
						System.out.println("4 - SALDO");
						System.out.println("5 - EXTRATO");
						System.out.println("6 - SAIR");
						System.out.println("|OPÇÃO: ");
						opcao  = sc1.nextInt();
						sc1.nextLine();
						BigDecimal valor;
						switch(opcao) {
							case 1:
								System.out.println("||Valor do Saque: ");
								valor = sc1.nextBigDecimal();
								sc1.nextLine();
								System.out.println("||Confirme sua senha: ");
								senha = sc1.next();
								b.sacar(senha, n_conta, valor);
								break;
							case 2:
								System.out.println("||Valor do Depósito: ");
								valor = sc1.nextBigDecimal();
								sc1.nextLine();
								System.out.println("||Confirme sua senha: ");
								senha = sc1.next();
								b.deposito(senha, n_conta, valor);
								break;
							case 3:
								System.out.println("||Valor da Transferência: ");
								valor = sc1.nextBigDecimal();
								sc1.nextLine();
								System.out.println("||Conta de destino: ");
								String n_conta_dest = sc1.next();
								System.out.println("||Confirme sua senha: ");
								senha = sc1.next();
								b.transferencia(senha, n_conta, n_conta_dest, valor);
								break;
							case 4:
								System.out.println("||Confirme sua senha: ");
								senha = sc1.next();
								System.out.println(b.saldo(senha, n_conta));
								break;
							case 5:
								System.out.println("||Confirme sua senha: ");
								senha = sc1.next();
								System.out.println(b.extrato(senha, n_conta));
								break;
							case 6:
								System.out.println("\nSaindo do sistema com sucesso!\nObrigado por usar Bahia Bancos");
								break;
							default:
								System.out.println("Operação inválida");
						}
					}
				}while(opcao != 6);
			}
			else {
				System.out.println("Não foi possível acessar a conta");
			}
			
		}
		catch (Exception e)
		{
			System.out.println("Não foi Possível acessar o Servidor 1");
			try
			{
				Banco b = (Banco) Naming.lookup("//192.168.0.14:1080/Banco");
				Scanner sc1 = new Scanner(System.in);
				System.out.println("-------------- BAHIA BANCO --------------\n");
				System.out.println("| Usuário:");
				String n_conta = sc1.nextLine();
				System.out.println("| Senha:");
				String senha = sc1.nextLine();
				//System.out.println(b.acessar_conta("1234", "00001"));
				if(b.acessar_conta(senha, n_conta)) {
					System.out.println("Conta acessada");
					int opcao = 0;
					do {
						if(b.acessar_conta(senha,n_conta)) {
							System.out.println("-------------- BAHIA BANCO --------------\n");
							System.out.println("---------------- OPÇÕES -----------------\n");
							System.out.println("1 - SACAR");
							System.out.println("2 - DEPOSITAR");
							System.out.println("3 - TRANSFERÊNCIA");
							System.out.println("4 - SALDO");
							System.out.println("5 - EXTRATO");
							System.out.println("6 - SAIR");
							System.out.println("|OPÇÃO: ");
							opcao  = sc1.nextInt();
							sc1.nextLine();
							BigDecimal valor;
							switch(opcao) {
								case 1:
									System.out.println("||Valor do Saque: ");
									valor = sc1.nextBigDecimal();
									sc1.nextLine();
									System.out.println("||Confirme sua senha: ");
									senha = sc1.next();
									b.sacar(senha, n_conta, valor);
									break;
								case 2:
									System.out.println("||Valor do Depósito: ");
									valor = sc1.nextBigDecimal();
									sc1.nextLine();
									System.out.println("||Confirme sua senha: ");
									senha = sc1.next();
									b.deposito(senha, n_conta, valor);
									break;
								case 3:
									System.out.println("||Valor da Transferência: ");
									valor = sc1.nextBigDecimal();
									sc1.nextLine();
									System.out.println("||Conta de destino: ");
									String n_conta_dest = sc1.next();
									System.out.println("||Confirme sua senha: ");
									senha = sc1.next();
									b.transferencia(senha, n_conta, n_conta_dest, valor);
									break;
								case 4:
									System.out.println("||Confirme sua senha: ");
									senha = sc1.next();
									System.out.println(b.saldo(senha, n_conta));
									break;
								case 5:
									System.out.println("||Confirme sua senha: ");
									senha = sc1.next();
									System.out.println(b.extrato(senha, n_conta));
									break;
								case 6:
									System.out.println("\nSaindo do sistema com sucesso!\nObrigado por usar Bahia Bancos");
									break;
								default:
									System.out.println("Operação inválida");
							}
						}
					}while(opcao != 6);
				}
				else {
					System.out.println("Não foi possível acessar a conta");
				}	
			}
			
			catch (Exception i)
			{
				System.out.println("Não foi Possível acessar o Servidor 2");
			}
		}
	}
}