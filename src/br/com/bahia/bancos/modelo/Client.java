package br.com.bahia.bancos.modelo;

import java.math.BigDecimal;
import java.rmi.Naming;

public class Client {
	public static void main(String[] args) throws Exception{
		try {
			Banco b = (Banco) Naming.lookup("//192.168.0.40:1080/Banco");
			b.acessar_conta("1234", "00001");
			System.out.println("PASSOU");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
