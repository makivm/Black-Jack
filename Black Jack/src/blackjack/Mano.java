package blackjack;

import java.util.ArrayList;

public class Mano extends Mazo {

	// • Constructor de la clase. Define una lista de caratas vacía, no invoca al
	// método de la superclase
	public Mano() {
		cartas = new ArrayList<>();
	}

	// • Método valorMano sin parámetros. Calcula cual es valor que tenemos en la
	// mano de cartas. Para hacerlo recorreremos la lista de cartas sumando los
	// puntos de cada una.
	public int valorMano() {
		int total = 0;
		for (Carta carta : cartas) {
			total = total + carta.getValor();
		}
		return total;
	}

	// • Método finDeJuego que devuelve un boolean, indicando true si la mano tiene
	// más de 21 puntos, significando que el jugador se ha pasado.
	public boolean finDeJuego() {
		if (valorMano() >= 21) {
			return true;
		}
		return false;
		// Forma mas corta-->return valorMano()>=21;
	}

	// • Sobreescribe el método toString para que invoque al método de la
	// superclase, pero antes muestre la puntuación de la mano
	@Override
	public String toString() {
		return "valor de la Mano=" + valorMano() + "\n" + super.toString();
	}

	// • Método pedirCarta(Mazo m) al que se le pasa un mazo de cartas,deberá
	// solicitar una carta al mazo e incluirla en la mano.
	public void pedirCarta(Mazo m) {
		if (!finDeJuego()) {
			Carta c=m.solicitarCarta();
			this.cartas.add(c);
		}
			
	}

}
