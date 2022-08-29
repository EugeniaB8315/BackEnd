package com.example.parametros.model;

public class ParametroSaab {

    // Cada parametro continen una id y su valor correspondiente que corresponde al estado actual del entrenador
    private Integer id;
    private Integer valor;

    ///////constructor///////
    public ParametroSaab() {
    }

    public ParametroSaab(Integer id, Integer valor) {
        this.id = id;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Parametro{" +
                "id=" + id +
                ", valor=" + valor +
                '}';
    }
}
