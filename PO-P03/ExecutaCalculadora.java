import java.util.Scanner;

public class ExecutaCalculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();

        System.out.println("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        System.out.println("Escolha a operação desejada:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");

        int escolha = scanner.nextInt();
        int resultado = 0;

        try {
            switch (escolha) {
                case 1:
                    resultado = calc.somar(num1, num2);
                    break;
                case 2:
                    resultado = calc.subtrair(num1, num2);
                    break;
                case 3:
                    resultado = calc.multiplicar(num1, num2);
                    break;
                case 4:
                    resultado = calc.dividir(num1, num2);
                    break;
                default:
                    System.out.println("Escolha inválida.");
            }
            System.out.println("Resultado da operação: " + resultado);
        } catch (DivisionByZeroException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        scanner.close();
    }
}
