package br.com.bahia.bancos.modelo;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.mysql.cj.Query;
import com.mysql.cj.result.RowList;

import br.com.bahia.bancos.modelo.Conta;

import br.com.bahia.bancos.util.JPAUtil;

public class BancoImpl extends UnicastRemoteObject implements Banco{
	
	private EntityManager em;

	protected BancoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean acessar_conta(String senha, String num_conta) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		javax.persistence.Query query = em.createQuery("SELECT senha FROM Conta  WHERE num_conta = "+num_conta);
		//Query query = em.createQuery("SELECT e FROM Employee e WHERE e.dept = :deptName");
		//query.setParameter("num_conta", num_conta);
		List<Conta> lista = query.getResultList();
		System.out.println(lista);
		
		return true;
		//TypedQuery<Conta> query = this.em.createQuery("select c from Conta c where c.num_conta = :num_conta and c.senha = :senha", Conta.class);
        //query.setParameter("num_conta", num_conta);
        //query.setParameter("senha", senha);

        //try{
        	//Conta conta = query.getSingleResult();
          //  if(num_conta.getSenha() == senha) return true;
          //  return false;
       // }catch(NoResultException e){
        //	System.out.println("eae");
       //     e.printStackTrace();
       // false;
       // }
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
