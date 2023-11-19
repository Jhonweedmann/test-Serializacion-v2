package org.example;

import java.io.Serializable;

public class Contenido implements Serializable {
    private String numero;
    public Contenido(){
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}
