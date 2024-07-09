package main.java.list.OperacoesBasicas;

public class Item {
    //Atributos:
    private String nome;
    private double preco;
    private int quantidade;

    // Constructor do objeto
    public Item(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Criado getters e setter para os atributos

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }



    @Override
    public String toString() {
        return "Item{" +
                "nome: '" + nome + '\'' +
                ", preco: " + preco +
                ", quantidade: " + quantidade +
                '}';
    }
}
