/*
Conversor de Temperatura:
Escreva um programa que converta a temperatura de graus Celsius para Fahrenheit
ou vice-versa, dependendo da escolha do usuário. O programa deve solicitar ao
usuário que insira a temperatura e a unidade de origem (Celsius ou Fahrenheit) e,
em seguida, realizar a conversão e exibir o resultado. A fórmula para a conversão de
Celsius para Fahrenheit é: F = (C * 9/5) + 32, onde F é a temperatura em Fahrenheit
e C é a temperatura em Celsius. 
 */
import java.util.Scanner;

public class ConversorTemperatura {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Digite a temperatura: ");
            double temperatura = sc.nextDouble();

            System.out.println("Escolha a unidade de origem:");
            System.out.println("1 - Celsius");
            System.out.println("2 - Fahrenheit");

            int escolha = sc.nextInt();
            double resultado = 0;

            switch (escolha) {
                case 1:
                    resultado = celsiusParaFahrenheit(temperatura);
                    System.out.println("Temperatura em Fahrenheit: " + resultado);
                    break;
                case 2:
                    resultado = fahrenheitParaCelsius(temperatura);
                    System.out.println("Temperatura em Celsius: " + resultado);
                    break;
                default:
                    System.out.println("Escolha inválida!");
            }
        }
    }

    // Método que converte Celsius para Fahrenheit
    public static double celsiusParaFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Método que converte Fahrenheit para Celsius
    public static double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
        
    }
}
