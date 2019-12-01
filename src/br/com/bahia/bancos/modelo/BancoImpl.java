package br.com.bahia.bancos.modelo;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bahia.bancos.util.JPAUtil;

public class BancoImpl extends UnicastRemoteObject implements Banco{
	
	private EntityManager em;

	protected BancoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean acessar_conta(String senha, String num_conta) {
        
		String q = "SELECT * FROM conta WHERE num_conta = "+num_conta;
		TypedQuery<Conta> query = em.createQuery(q, Conta.class);
		
		List<Conta> contas = query.getResultList();
		
		for (Conta c:contas) {
			if(c.getSenha() == senha) return true;
		}
		return false;
	}

	@Override
	public void sacar(String senha, String num_conta, BigDecimal valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposito(String senha, String num_conta, BigDecimal valor, Integer destino) {
		// TODO Auto-generated method stub
		
	}

}
