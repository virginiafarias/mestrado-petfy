package model;

import java.util.Date;

/**
 * Created by Virginia Farias on 14/09/2016.
 */
public class Vacina {

    private int id;

    private String nome;

    private Date data;

    private boolean vacinado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacina vacina = (Vacina) o;

        return id == vacina.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
