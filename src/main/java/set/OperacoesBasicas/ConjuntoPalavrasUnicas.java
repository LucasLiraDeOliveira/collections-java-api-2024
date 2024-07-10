package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavraUnicaSet;

    public ConjuntoPalavrasUnicas() {
        this.palavraUnicaSet = new HashSet<>();
    }


    //esses dois @ são a parte de equals() e hashCode() para evitar repetição de objetos, que o set premedita
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConjuntoPalavrasUnicas that)) return false;
        return Objects.equals(palavraUnicaSet, that.palavraUnicaSet);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(palavraUnicaSet);
    }



    public void adicionarPalavra(String palavra){
        palavraUnicaSet.add(new String(palavra));
    }


    public void removerPalavra(String palavra){
        if (!palavraUnicaSet.isEmpty()){
            if (palavraUnicaSet.contains(palavra))
                palavraUnicaSet.remove(palavra);
            else
                System.out.println("A palabra '"+ palavra + "' não faz parte desse conjunto de palavras únicas");
        } else
            System.out.println("A lista de palavras únicas está vazio");
    }


    public boolean verificarPalavra(String palavra){
        return palavraUnicaSet.contains(palavra);
    }


    public void exibirPalavrasUnicas(){
        if(!palavraUnicaSet.isEmpty()) {
            System.out.println(palavraUnicaSet);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }


    public static void main(String[] args) {
        // Criando uma instância da classe ConjuntoPalavrasUnicas
        ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

        // Adicionando linguagens únicas ao conjunto
        conjuntoLinguagens.adicionarPalavra("Java");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("JavaScript");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("C++");
        conjuntoLinguagens.adicionarPalavra("Ruby");

        // Exibindo as linguagens únicas no conjunto
        conjuntoLinguagens.exibirPalavrasUnicas();

        // Removendo uma linguagem do conjunto
        conjuntoLinguagens.removerPalavra("Python");
        conjuntoLinguagens.exibirPalavrasUnicas();

        // Removendo uma linguagem inexistente
        conjuntoLinguagens.removerPalavra("Swift");

        // Verificando se uma linguagem está no conjunto
        System.out.println("A linguagem 'Java' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Java"));
        System.out.println("A linguagem 'Python' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Python"));

        // Exibindo as linguagens únicas atualizadas no conjunto
        conjuntoLinguagens.exibirPalavrasUnicas();
    }
}
