package main;

import java.util.ArrayList;
import java.util.Random;

public class Baralho {
	private ArrayList<Carta> cartas;

	public Baralho() {
		this.cartas = new ArrayList<Carta>();
		
		Carta carta1 = new Carta("Geezard", 1,5,1,4, "NEUTRAL");
		cartas.add(carta1);
		Carta carta2 = new Carta("Funguar", 5,3,1,1, "NEUTRAL");
		cartas.add(carta2);
		Carta carta3 = new Carta("Bite Bug", 1,5,3,3, "NEUTRAL");
		cartas.add(carta3);
		Carta carta4 = new Carta("Red Bat", 6,2,1,1, "NEUTRAL");
		cartas.add(carta4);
		Carta carta5 = new Carta("Blobra", 2,5,1,3, "NEUTRAL");
		cartas.add(carta5);
		Carta carta6 = new Carta("Gayla", 2,4,4,1, "THUNDER");
		cartas.add(carta6);
		Carta carta7 = new Carta("Gesper", 1,1,4,5, "NEUTRAL");
		cartas.add(carta7);
		Carta carta8 = new Carta("Fastitocalon-F", 3,1,2,5, "EARTH");
		cartas.add(carta8);
		Carta carta9 = new Carta("Blood Soul", 2,1,6,1, "NEUTRAL");
		cartas.add(carta9);
		Carta carta10 = new Carta("Caterchipillar", 4,3,4,2, "NEUTRAL");
		cartas.add(carta10);
		Carta carta11 = new Carta("Cockatrice", 2,6,2,1, "THUNDER");
		cartas.add(carta11);
		Carta carta12 = new Carta("Grat", 7,1,3,1, "NEUTRAL");
		cartas.add(carta12);
		Carta carta13 = new Carta("Buel", 6,3,2,2, "NEUTRAL");
		cartas.add(carta13);
		Carta carta14 = new Carta("Mesmerize", 5,4,3,3, "NEUTRAL");
		cartas.add(carta14);
		Carta carta15 = new Carta("Glacial Eye", 6,3,4,1, "ICE");
		cartas.add(carta15);
		Carta carta16 = new Carta("Belhelmel", 3,3,5,4, "NEUTRAL");
		cartas.add(carta16);
		Carta carta17 = new Carta("Thrustaevis", 5,5,2,3, "WIND");
		cartas.add(carta17);
		Carta carta18 = new Carta("Anacondaur", 5,5,3,1, "POISON");
		cartas.add(carta18);
		Carta carta19 = new Carta("Creeps", 5,2,5,2, "THUNDER");
		cartas.add(carta19);
		Carta carta20 = new Carta("Grendel", 4,2,5,4, "THUNDER");
		cartas.add(carta20);
	}
	
	public ArrayList<Carta> embaralhar(){
		Random gerador = new Random();
		ArrayList<Carta> cartasJogador = new ArrayList<Carta>();
		for(int i = 0; i<5; i++) {
			cartasJogador.add(cartas.get(gerador.nextInt(cartas.size())));
		}
		return cartasJogador;
	}
	

}
