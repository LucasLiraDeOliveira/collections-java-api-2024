package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    List<Integer> numeros;

    //Constructor
    public SomaNumeros() {
        this.numeros = new ArrayList<>();
    }


    public void adicionarNumero(int numero){
        this.numeros.add(numero);
    }


    public int calcularSoma(){
        int totalSoma = 0;
        if (!numeros.isEmpty()){
            for (Integer numero : numeros){
                totalSoma += numero;
            }
            return totalSoma;
        } else {
            System.out.println("Lista está vazia!");
            return totalSoma;
        }
    }


    public int encontrarMaiorNumero(){
        int maiorNumero = Integer.MIN_VALUE;

        if (!numeros.isEmpty()){
            for (Integer numero : numeros) {
                if (numero > maiorNumero)
                    maiorNumero = numero;
            }
            return maiorNumero;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }


    public int encontrarMenorNumero(){
        int menorNumero = Integer.MAX_VALUE;

        if (!numeros.isEmpty()){
            for (Integer numero : numeros) {
                if (numero < menorNumero)
                    menorNumero = numero;
            }
            return menorNumero;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }


    public void exibirNumeros(){
        if (!numeros.isEmpty()){
            System.out.println("\nA lista de números é:");
            System.out.println(numeros);
        } else {
            System.out.println("A lista está vazia!");
        }
    }


    public static void main(String[] args) {
        // Criando uma instância da classe SomaNumeros
        SomaNumeros somaNumeros = new SomaNumeros();

        // Adicionando números à lista
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(-2);
        somaNumeros.adicionarNumero(10);

        // Exibindo a lista de números adicionados
        System.out.println("Números adicionados:");
        somaNumeros.exibirNumeros();

        // Calculando e exibindo a soma dos números na lista
        System.out.println("Soma dos números = " + somaNumeros.calcularSoma() + "\n");

        // Encontrando e exibindo o maior número na lista
        System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero() + "\n");

        // Encontrando e exibindo o menor número na lista
        System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
    }
}
