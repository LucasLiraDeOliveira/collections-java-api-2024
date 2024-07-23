package main.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    *  Predicate<T>:
    * Representa uma função que aceita um argumento do tipo T e retorna um valor booleano (verdadeiro ou falso).
    * É comumente usada para filtrar os elementos do Stream com base em alguma condição.
*/


public class PredicateExample {
    public static void main(String[] args) {
        // Criar uma lista de números inteiros
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        // FORMA 1:
        System.out.println("\nForma 1:");
        // Usar o Predicate com expressão lambda para filtrar números pares
        Predicate<Integer> isPar = numero -> numero % 2 == 0;

        // Usar o predicado para filtrar números pares no Stream e armazená-los em outra lista
        List<Integer> numerosPares = numeros.stream()
                .filter(isPar)
                .toList();

        // Imprimir a lista de números pares
        numerosPares.forEach(System.out::println);


        // FORMA 2:
        System.out.println("\nForma 2:");
        List<Integer> numerosPares2 = numeros.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer n) {
                        return n % 2 == 0;
                    }
                })
                .toList();

        // Imprimir a lista de números pares
        numerosPares2.forEach(System.out::println);


        // FORMA 3:
        System.out.println("\nForma 3:");
        List<Integer> numerosPares3 = numeros.stream()
                .filter(n ->  n % 2 == 0)
                .toList();

        // Imprimir a lista de números pares
        numerosPares3.forEach(System.out::println);
    }
}
