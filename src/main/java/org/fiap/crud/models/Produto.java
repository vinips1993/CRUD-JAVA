package org.fiap.crud.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    private int codigo;
    private String nome;
    private float valor;
    private Calendar dataValidade;

    public Produto(int codigo, String nome, float valor, Calendar dataValidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.dataValidade = dataValidade;
    }

    public void Produto() {};

    public int getCodigo() {
        return codigo;
    }

    public Produto setCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public float getValor() {
        return valor;
    }

    public Produto setValor(float valor) {
        this.valor = valor;
        return this;
    }

    public Calendar getDataValidade() {
        return dataValidade;
    }

    public Produto setDataValidade(Calendar dataValidade) {
        this.dataValidade = dataValidade;
        return this;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mmyyy");
        return "Produto [codigo=" + codigo
                + ", nome=" + nome
                + ", valor=" + valor
                + ", dataValidade="
                + sdf.format(dataValidade.getTime())+"]";
    }
}
