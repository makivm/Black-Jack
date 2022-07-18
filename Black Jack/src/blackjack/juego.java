package blackjack;

import java.util.Scanner;

public class juego {

	public static void main(String[] args) {
		Mazo mazo=new Mazo();
		Mano jugador=new Mano();
		
		System.out.println("Barajando cartas...");
		mazo.barajar();
		
		Scanner entrada=new Scanner(System.in);
		int opcion;
				
		do {
			System.out.println("¿Quieres carta? (1-SI,0-NO)");
			opcion=entrada.nextInt();		
			if (opcion==1) {
			jugador.pedirCarta(mazo);
			System.out.println("Tienes en tu mano \n"+jugador);
			}
		}while (opcion!=0 && !jugador.finDeJuego());
		
		if (jugador.valorMano()==21)
			System.out.println("Campeon.Has conseguido 21\n");
		else if (jugador.valorMano()>21) 
			System.out.println("Te has pasado.");
		else System.out.println("Te has plantado con "+jugador.valorMano());
		
		entrada.close();
	}
}