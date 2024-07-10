package main.java.set.Pesquisa;

import java.util.Objects;

public class Contato {
    private String nome;
    private int numeroTelefone;

    //Constructor

    public Contato(String nome, int numeroTelefone) {
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
    }


    //equals() e hashCode() para evitar repetição de objetos


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato contato)) return false;
        return getNumeroTelefone() == contato.getNumeroTelefone() && Objects.equals(getNome(), contato.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getNumeroTelefone());
    }

    //Metodos getter das variaveis de Contato
    public String getNome() {
        return nome;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public String toString() {
        return "{" + nome + ", " + numeroTelefone + "}";
    }
}
