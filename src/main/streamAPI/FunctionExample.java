package main.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    * Function<T, R>: Representa uma função que aceita um argumento do tipo T e retorna um resultado do tipo R.
    * É utilizada para transformar ou mapear os elementos do Stream em outros valores ou tipos.
*/


public class FunctionExample {
    public static void main(String[] args) {
        // Criar uma lista de números inteiros
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);


        // FORMA 1:
        System.out.println("\nForma 1:");
        // Usar a Function com expressão lambda para dobrar todos os números
        Function<Integer, Integer> dobrar = numero -> numero * 2;

        // Usar a função para dobrar todos os números no Stream e armazená-los em outra lista
        List<Integer> numerosDobrados = numeros.stream()
                .map(dobrar)
                .toList();

        // Imprimir a lista de números dobrados
        numerosDobrados.forEach(System.out::println); // isso era: (n -> System.out.println(n))


        // FORMA 2:
        System.out.println("\nForma 2:");
        // Usar a Function com expressão lambda para dobrar todos os números
        Function<Integer, Integer> dobrar2 = numero -> numero * 2;

        // Usar a função para dobrar todos os números no Stream e armazená-los em outra lista
        List<Integer> numerosDobrados2 = numeros.stream()
                .map(new Function<Integer, Integer>() {
                         @Override
                         public Integer apply(Integer n) {//metodo apply ele recebe um tipo
                             // e entrega outro
                             return n * 2;
                         }
                     }
                )
                .toList();

        // Imprimir a lista de números dobrados
        numerosDobrados2.forEach(System.out::println);


        // FORMA 3:
        System.out.println("\nForma 3:");
        // Usar a Function com expressão lambda para dobrar todos os números
        Function<Integer, Integer> dobrar3 = numero -> numero * 2;

        // Usar a função para dobrar todos os números no Stream e armazená-los em outra lista
        List<Integer> numerosDobrados3 = numeros.stream()
                .map(n -> n * 2)
                .toList();

        // Imprimir a lista de números dobrados
        numerosDobrados3.forEach(System.out::println);


    }
}
