package br.com.bahia.bancos.modelo;

import javax.persistence.*;

import br.com.bahia.bancos.modelo.Pessoa;
import br.com.bahia.bancos.modelo.Transacao;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String agencia;
    private String num_conta;
    private String senha;
    private BigDecimal saldo;
    private String tipo;
    
    @OneToOne
    @JoinColumn(unique=true)
    private Pessoa pessoa;
    
    @OneToMany(mappedBy = "conta")
    private List<Transacao> movimentacoes;

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNum_conta() {
		return num_conta;
	}

	public void setNum_conta(String num_conta) {
		this.num_conta = num_conta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
    
    
}