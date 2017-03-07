package com.list.filter;

import java.util.function.Predicate;

public class Pessoa implements Entidade{
    private static final long serialVersionUID = -8487274034927037828L;

    private Integer id;
    private String nome;
    private int indade;
    private Sexo sex;

    public Pessoa(Integer id, String nome, int indade, Sexo sex) {
        this.id = id;
        this.nome = nome;
        this.indade = indade;
        this.sex = sex;
    }

    public Pessoa(String nome, int indade, Sexo sex) {
        this.id = id;
        this.nome = nome;
        this.indade = indade;
        this.sex = sex;
    }

    public Pessoa(int indade, Sexo sex) {
        this.indade = indade;
        this.sex = sex;
    }

    public static Predicate<Pessoa> isAdultMale() {
        return u -> u.getIndade() >= 18 && u.getSex().equals(Sexo.MALE);
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIndade() {
        return indade;
    }

    public void setIndade(int indade) {
        this.indade = indade;
    }

    public Sexo getSex() {
        return sex;
    }

    public void setSex(Sexo sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return id + " " + nome + " " + indade + " " + sex;
    }
}
