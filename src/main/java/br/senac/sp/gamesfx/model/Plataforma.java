package br.senac.sp.gamesfx.model;

import java.time.LocalDate;
import java.util.Date;

public class Plataforma {

    private int id;
    private String nome;
    private String fabricante;
    private LocalDate dataLancamento;
    private double valor;

    public Plataforma(int id, String nome, String fabricante) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
    }

    // Construtor Default/Padrão
    public Plataforma() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "id= " + id +
                ", nome= " + nome + '\'' +
                ", fabricante= " + fabricante + '\'' +
                ", dataLancamento= " + dataLancamento +
                ", preco= " + valor + '\'' +
                '}';
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
