package main.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/*
    *  BinaryOperator<T>: Representa uma operação que combina dois argumentos do tipo T e retorna um resultado do mesmo tipo T.
    * É usada para realizar operações de redução em pares de elementos, como somar números ou combinar objetos.
*/


public class BinaryOperatorExample {
    public static void main(String[] args) {
        // Criar uma lista de números inteiros
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);


        // FORMA 1:
        System.out.println("\nForma 1:");
        // Usar o BinaryOperator com expressão lambda para somar dois números inteiros
        BinaryOperator<Integer> somar = (num1, num2) -> num1 + num2;

        // Usar o BinaryOperator para somar todos os números no Stream
        int resultado = numeros.stream()
                .reduce(0, somar); // o IDENTITY é "como se fosse uma variável temporária" que
                                          // acumula os valores somados e retorna o valor final,
                                          // por isso inicializado em zero.

        // Imprimir o resultado da soma
        System.out.println("A soma dos números é: " + resultado);


        // FORMA 2:
        System.out.println("\nForma 2:");
        // Usar o BinaryOperator para somar todos os números no Stream
        int resultado2 = numeros.stream()
                .reduce(0, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer n1, Integer n2) {
                        return n1 + n2;
                    }
                });

        // Imprimir o resultado da soma
        System.out.println("A soma dos números é: " + resultado2);


        // FORMA 3:
        System.out.println("\nForma 3:");
        // Usar o BinaryOperator para somar todos os números no Stream
        int resultado3 = numeros.stream()
                .reduce(0, (n1, n2) -> n1 + n2);

        // Imprimir o resultado da soma
        System.out.println("A soma dos números é: " + resultado3);


        // FORMA 4: o exemplo anterior mas usando lambda
        System.out.println("\nForma 4:");
        // Usar o BinaryOperator para somar todos os números no Stream
        int resultado4 = numeros.stream()
                .reduce(0, Integer::sum);

        // Imprimir o resultado da soma
        System.out.println("A soma dos números é: " + resultado4);
    }
}
