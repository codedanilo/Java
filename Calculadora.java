/*
Calculadora Simples:
Crie um programa que funcione como uma calculadora simples. O programa deve
pedir ao usuário que insira dois números e depois escolha uma operação (adição,
subtração, multiplicação ou divisão). Em seguida, o programa deve calcular o
resultado e exibi-lo. 
 */

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double num1 = sc.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = sc.nextDouble();

        System.out.println("Escolha a operação:");
        System.out.println("1 - Adição");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");

        int escolha = sc.nextInt();
        double resultado = 0;

        switch (escolha) {
            case 1:
                resultado = num1 + num2;
                break;
            case 2:
                resultado = num1 - num2;
                break;
            case 3:
                resultado = num1 * num2;
                break;
            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Não é possível dividir por zero.");
                    return;
                }
                break;
            default:
                System.out.println("Escolha inválida!");
                return;
        }

        System.out.println("Resultado: " + resultado);
        System.out.close();
    }
}
