package blackjack;

import java.util.Scanner;

public class juego {

	public static void main(String[] args) {
		Mazo mazo=new Mazo();
		Mano jugador=new Mano();
		Mano banca=new Mano();
		
		System.out.println("Barajando cartas...");
		mazo.barajar();
		
		//Mano del jugador
		System.out.println("\n-----------------------------------------------------\n		Repartiendo cartas Iniciales...\n-----------------------------------------------------");
		jugador.pedirCarta(mazo);
		banca.pedirCarta(mazo);	
		jugador.pedirCarta(mazo);
		banca.pedirCarta(mazo,false);
		
		System.out.println("Jugador, tienes en tu mano \n"+jugador);
		System.out.println("Banca, tienes en tu mano \n"+banca);
		
		
		Scanner entrada=new Scanner(System.in);
		int opcion;
		
		do {
			System.out.println("\n-----------------------------------------------------\n		Jugador en proceso...\n-----------------------------------------------------");
			System.out.println("¿Jugador, Quieres carta? (1-SI,0-NO)");
			opcion=entrada.nextInt();		
			if (opcion==1) {
			jugador.pedirCarta(mazo);
			System.out.println("Tienes en tu mano \n"+jugador);
			}
		}while (opcion!=0 && !jugador.finDeJuego());
		
		//Mensajes de jugador
		if (jugador.valorMano()==21)
			System.out.println("Campeon.Has conseguido 21\n");
		else if (jugador.valorMano()>21) 
			System.out.println("Te has pasado.");
		else System.out.println("Te has plantado con "+jugador.valorMano());
		
		
		//Mano de la banca--Comparacion de banca con jugador
		
		System.out.println("\n-----------------------------------------------------\n		Juega la banca...\n-----------------------------------------------------");
		
		banca.descubrir();
		if (jugador.valorMano()>21)
			System.out.println("\nGana la banca");
		
		else {
			do {
				System.out.println("Pidiendo carta...");
				banca.pedirCarta(mazo);
				System.out.println("Valor de la mano "+banca);
			
			}while (banca.valorMano()<=16);
			
			if(jugador.valorMano()>banca.valorMano()||banca.valorMano()>21) 
				System.out.println("Enhorabuena Jugador, has ganado!! "+jugador);
			else if (jugador.valorMano()==banca.valorMano())
				System.out.println("Empate \nJugador: "+jugador+"|nBanca: "+banca);
			else 
				System.out.println("Gana la banca: "+banca);
		}
		entrada.close();
	}
}