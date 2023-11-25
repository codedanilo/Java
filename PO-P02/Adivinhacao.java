/* 
1. Conversor de Moedas:
Crie um programa que converta uma quantidade em dólares para outra moeda (por
exemplo, euros ou reais). Peça ao usuário que insira a taxa de câmbio e a
quantidade em dólares. Em seguida, calcule e exiba o valor convertido. 

*/  

package adivinhacao;

import java.util.Random;
import java.util.Scanner;

public class Adivinhacao {

	private int numero;

	public double getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Adivinhacao adivinha = new Adivinhacao();
		int num,numAleatorio;
		
		Random aleatorio = new Random();
		numAleatorio = aleatorio.nextInt(100);
		
		do
		{
		   System.out.println("Digite o numero da adivinhacao: ");
		   num = input.nextInt();

		   if(num > numAleatorio)
		   {
		    System.out.println("# Seu palpite esta alto! #");
		   }
		   if(num < numAleatorio)
		   {
		    System.out.println("# Seu palpite esta baixo! #");
		   }
		   if(num == numAleatorio)
		   {
		    System.out.println(numAleatorio + "  * * PARABENS! Voce acertou o numero! * *  ");
		   }

		} while(num != numAleatorio);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
