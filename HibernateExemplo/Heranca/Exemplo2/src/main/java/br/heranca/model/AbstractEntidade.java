package br.heranca.model;

import java.io.Serializable;
import java.util.Random;

public abstract class AbstractEntidade implements Entidade, Serializable {

    private static final long serialVersionUID = 4963221767794543431L;
    private int random = new Random().nextInt(Integer.MAX_VALUE);

    public int getRandomId() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }
    
    @Override
    public Serializable getId() {
        return null;
    }

    @Override
    public String getDisplay() {
        return null;
    }
}
