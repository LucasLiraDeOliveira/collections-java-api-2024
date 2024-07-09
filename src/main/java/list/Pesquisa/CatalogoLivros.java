package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        Livro novoLivro = new Livro(titulo, autor, anoPublicacao);
        livroList.add(novoLivro);

        // Ou apenas:
        // livroList.add(new Livro(titulo, autor, anoPublicacao));
    }


    public void pesquisarPorAutor(String autor){
        List<Livro> listaPorAutor = new ArrayList<>();

        if(!livroList.isEmpty()){
            for (Livro L : livroList){
                if(L.getAutor().equalsIgnoreCase(autor)){
                    listaPorAutor.add(L);
                }
            }

            if(listaPorAutor.isEmpty()){
                System.out.println("O catálogo não possui Livros do autor " + autor);
            } else if(listaPorAutor.size()>1) {
                System.out.println("Os livros do autor " + autor + " encontrados em nosso catálogo são:");
                System.out.println(listaPorAutor);
            } else {
                System.out.println("O livro do autor " + autor + " encontrado em nosso catálogo foi:");
                System.out.println(listaPorAutor);
            }

        } else{
            System.out.println("O catálogo está vazio!");
        }
    }


    public void pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> listaPorPeriodo = new ArrayList<>();

        if(!livroList.isEmpty()){
            for (Livro L : livroList){
                if(anoInicial <= L.getAnoPublicacao() && L.getAnoPublicacao() <= anoFinal){
                    listaPorPeriodo.add(L);
                }
            }

            if(listaPorPeriodo.isEmpty()){
                System.out.println("O catálogo não possui Livros publicados entre " + anoInicial + " e " + anoFinal);
            } else if(listaPorPeriodo.size()>1) {
                System.out.println("Os livros publicados entre " + anoInicial + " e " + anoFinal + " encontrados em nosso catálogo são:");
                System.out.println(listaPorPeriodo);
            } else {
                System.out.println("O livro publicado entre " + anoInicial + " e " + anoFinal + " encontrado em nosso catálogo foi:");
                System.out.println(listaPorPeriodo);
            }

        } else{
            System.out.println("O catálogo está vazio!");
        }
    }


    public void pesquisarPorTitulo(String titulo){
        // Como dessa vez precisamos apenas de um item, vamos criar um objeto do tipo Livro em vez do: List<Livro> listaPorTitulo = new Arraylist();
        Livro listaPorTitulo = null;

        if(!livroList.isEmpty()){
            for (Livro L : livroList){
                if(L.getTitulo().equalsIgnoreCase(titulo)){
                    listaPorTitulo = L;
                    break;
                }
            }

            if(listaPorTitulo == null){
                System.out.println("O catálogo não possui o Livro " + titulo);
            } else {
                System.out.println("O catálogo possui o Livro " + titulo);
                System.out.println(listaPorTitulo);
            }

        } else{
            System.out.println("O catálogo está vazio!");
        }
    }


    public static void main(String[] args) {
        // Criando a instancia do catalogo de livros
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        // Adicionando livros ao catálogo
        catalogoLivros.adicionarLivro("Microsserviços Prontos Para a Produção", "Susan J. Fowler", 2017);
        catalogoLivros.adicionarLivro("Java Guia do Programador", "Peter Jandl Junior", 2021);
        catalogoLivros.adicionarLivro("Código Limpo", "Robert C. Martin", 2009);
        catalogoLivros.adicionarLivro("O Codificador Limpo", "Robert C. Martin", 2012);

        // Exibindo livros pelo mesmo autor
        catalogoLivros.pesquisarPorAutor("Robert C. Martin");

        // Exibindo livros pelo mesmo autor (caso em que não há livros de um autor específico)
        catalogoLivros.pesquisarPorAutor("Autor Inexistente");
        System.out.println("\n");


        // Exibindo livros dentro de um intervalo de anos
        catalogoLivros.pesquisarPorIntervaloAnos(2010, 2022);

        // Exibindo livros dentro de um intervalo de anos (caso em que não há livros no intervalo)
        catalogoLivros.pesquisarPorIntervaloAnos(2025, 2030);
        System.out.println("\n");



        // Exibindo livros por título
        catalogoLivros.pesquisarPorTitulo("Java Guia do Programador");

        // Exibindo livros por título (caso em que não há livros com o título especificado)
        catalogoLivros.pesquisarPorTitulo("Título Inexistente");
        System.out.println("\n");
    }
}
