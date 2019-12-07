package br.com.bahia.bancos.teste;

import javax.persistence.EntityManager;


import br.com.bahia.bancos.modelo.Conta;
import br.com.bahia.bancos.modelo.Pessoa;
import br.com.bahia.bancos.util.JPAUtil;

public class TesteContaPessoa {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Pessoa pessoa = em.find(Pessoa.class, 2);
        Conta conta = em.find(Conta.class, 2);
        
        conta.setPessoa(pessoa);
        
        em.persist(conta);
        em.getTransaction().commit();
		em.close();
	
	}
}
