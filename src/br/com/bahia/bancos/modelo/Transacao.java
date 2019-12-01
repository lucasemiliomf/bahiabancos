package br.com.bahia.bancos.modelo;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.bahia.bancos.modelo.Conta;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.persistence.*;

@Entity
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private BigDecimal valor;
	private Integer idOrigem;
	private Integer idDestino;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@ManyToOne
	private Conta conta;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getIdOrigem() {
		return idOrigem;
	}

	public void setIdOrigem(Integer idOrigem) {
		this.idOrigem = idOrigem;
	}

	public Integer getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		if(idOrigem == null) {
			return "Transação: Depósito [data=" + data.getTime() +", valor=" + valor + "]\n";
		}
		if(idDestino == null) {
			return "Transação: Saque [data=" + data.getTime() +", valor=" + valor + "]\n";
		}
		if(idDestino != conta.getId()) {
			return "Transação: Transferência [data=" + data.getTime() +", valor=" + valor + ", idDestino=" + idDestino + "]\n";
		}
		return "";
		
	}
	
	

}