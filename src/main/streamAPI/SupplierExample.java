package main.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Representa uma operação que não aceita nenhum argumento e retorna um resultado do tipo T.
 * É comumente usada para criar ou fornecer novos objetos de um determinado tipo.
 */


public class SupplierExample {
    public static void main(String[] args) {
        // Usar o Supplier com expressão lambda para fornecer uma saudação personalizada
        Supplier<String> saudacao = () -> "Olá, seja bem-vindo(a)!";

        // FORMA 1:
        System.out.println("\nForma 1:");
        // Usar o Supplier para obter uma lista com 5 saudações
        List<String> listaSaudacoes = Stream.generate(saudacao)
                .limit(5)
                .toList();
        //.collect(Collectors.toList());

        // Imprimir as saudações geradas
        listaSaudacoes.forEach(System.out::println);


        // FORMA 2:
        System.out.println("\nForma 2:");
        List<String> listaSaudacoes2 = Stream.generate(
                        new Supplier<String>() {
                            @Override
                            public String get() {
                                return "Olá, seja bem-vindo(a)!";
                            }
                        })
                .limit(5)
                .toList();
        //.collect(Collectors.toList());

        // Imprimir as saudações geradas
        listaSaudacoes2.forEach(System.out::println);


        // FORMA 3:
        System.out.println("\nForma 3:");
        List<String> listaSaudacoes3 = Stream.generate(() -> "Olá, seja bem-vindo(a)!")
                .limit(5)
                .toList();
        //.collect(Collectors.toList());

        // Imprimir as saudações geradas
        listaSaudacoes3.forEach(System.out::println);


        // FORMA 4:
        System.out.println("\nForma 4:");
        // Usar o Supplier com uma classe anônima para fornecer uma saudação personalizada
        Supplier<String> saudacao4 = new Supplier<String>() {
            @Override
            public String get() {
                return "Olá, seja bem-vindo(a)!";
            }
        };

        // Usar o Supplier para obter uma lista com 5 saudações
        List<String> listaSaudacoes4 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listaSaudacoes4.add(saudacao.get());
        }

        // Imprimir as saudações geradas
        for (String saudacaoGerada : listaSaudacoes4) {
            System.out.println(saudacaoGerada);
        }
    }
}
