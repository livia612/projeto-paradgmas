package main;


public class Tabuleiro {
	private Carta[][] matriz = new Carta[3][3];
	private Jogador jogador1;
	private Jogador jogador2;
	

	public boolean cadastrarJogadores(String nome1, String nome2) {
		if(nome1.equalsIgnoreCase(nome2)) {
			return false;
		}
		jogador1 = new Jogador(nome1);
		jogador2 = new Jogador(nome2);
		return true;
	}
	
	

}
