package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    //Atributo
    private List<Item> itensCarrinho;

    //Constructor para garantir que o array vai ta vazio
    public CarrinhoDeCompras() {
        this.itensCarrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        Item item = new Item(nome,preco,quantidade);
        itensCarrinho.add(item);
    }

    public void removerItem(String nome){
        if(!itensCarrinho.isEmpty()){
            List<Item> itemParaRemover = new ArrayList<>();

            for (Item i : itensCarrinho) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itemParaRemover.add(i);
                }
            }

            itensCarrinho.removeAll(itemParaRemover);
        } else {
            System.out.println("O carrinho está vazio!");
        }
    }

    public void calcularValorTotal(){
        double total = 0d;
        if(!itensCarrinho.isEmpty()){
            for (Item item : itensCarrinho) {
                total += (item.getQuantidade() * item.getPreco());
            }

            System.out.println("O valor total do carrinho é de R$" + String.format("%.2f", total));

        } else {
            System.out.println("O carrinho está vazio!");
        }
    }

    public void exibirItens(){
        if (!itensCarrinho.isEmpty()) {
            System.out.println(this.itensCarrinho);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        //Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("Brusinha", 120d, 2);
        carrinhoDeCompras.adicionarItem("Brusinha", 120d, 2);
        carrinhoDeCompras.adicionarItem("Calça", 330.85d, 3);
        carrinhoDeCompras.adicionarItem("Bôta", 400d, 1);

        //Calculando total do carrinho
        carrinhoDeCompras.calcularValorTotal();
        //Exibindo o carrinho atual
        carrinhoDeCompras.exibirItens();

        //Removendo os itens "Brusinha" do carrinho
        carrinhoDeCompras.removerItem("Brusinha");
        //Exibindo o carrinho atual
        carrinhoDeCompras.exibirItens();
    }
}
