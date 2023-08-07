package com.example.projetoSpring.models;

import jakarta.persistence.*;

@Entity
@Table(name="contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    private String nome,numero_conta;
    private Integer agencia;

    private Double valor_inicial,valor_final;

    public Conta() {
    }

    public Conta(Long id, String nome, String numero_conta, Integer agencia, Double valor_inicial, Double valor_final) {
        this.id = id;
        this.nome = nome;
        this.numero_conta = numero_conta;
        this.agencia = agencia;
        this.valor_inicial = valor_inicial;
        this.valor_final = valor_final;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(String numero_conta) {
        this.numero_conta = numero_conta;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Double getValor_inicial() {
        return valor_inicial;
    }

    public void setValor_inicial(Double valor_inicial) {
        this.valor_inicial = valor_inicial;
    }

    public Double getValor_final() {
        return valor_final;
    }

    public void setValor_final(Double valor_final) {
        this.valor_final = valor_final;
    }

    public Double depositar(Double qtd){
        Double total=this.valor_final;
        total+=qtd;
        return total;
    }

    public Double sacar(Double qtd){
        Double total=this.valor_final;
        total-=qtd;
        return total;
    }
}
