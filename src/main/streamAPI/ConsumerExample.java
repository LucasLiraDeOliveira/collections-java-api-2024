package main.streamAPI;

import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;

/*
 * Representa uma operação que aceita um argumento do tipo T e não retorna nenhum resultado.
 * É utilizada principalmente para realizar ações, ou efeitos colaterais nos elementos do
 * Stream sem modificar, ou retornar um valor.
 */


public class ConsumerExample {
    public static void main(String[] args) {
        // Criar uma lista de números inteiros
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // FORMA 1:
        System.out.println("\nForma 1:");
        // Usar o Consumer com expressão lambda para imprimir números pares
        Consumer<Integer> imprimirNumeroPar = numero -> {
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
        };

        // Usar o Consumer para imprimir números pares no Stream
        numeros.stream().forEach(imprimirNumeroPar);


        // FORMA 2: caso não saiba implementar um Consumer
        System.out.println("\nForma 2:");
        numeros.stream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                if(n % 2 == 0){
                    System.out.println(n);
                }
            }
        });


        // FORMA 3: usando lambda
        System.out.println("\nForma 3:");
        numeros.stream().forEach(n -> {
            if(n % 2 == 0){
                System.out.println(n);
            }
        });


        // FORMA 4: simplificando mais ainda e só pondo o forEach
        System.out.println("\nForma 4:");
        numeros.forEach(n -> {
            if(n % 2 == 0){
                System.out.println(n);
            }
        });


        // FORMA 5: usando filter e predicate para fazer o mesmo do exemplo anterior
        System.out.println("\nForma 5:");
        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}

