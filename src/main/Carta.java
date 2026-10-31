package main;

public class Carta {
    String nome;
    int cima, baixo, esquerdo, direito;
    String elemento;
    String dono;

	public Carta(String nome, int cima, int esquerdo, int baixo, int direito, String elemento) {
		this.nome = nome;
		this.cima = cima;
		this.esquerdo = esquerdo;
		this.baixo = baixo;
		this.direito = direito;
		this.elemento = elemento;
	}

	public String toString() {
		String carta = "";
        carta+="        " + cima + "\n";
        carta+="  " + esquerdo + " ["+ nome +"] " + direito + "\n";
        carta+="        " + baixo + "\n";
        carta+="⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯";
        return carta;
    }
	
	
	
    

    
    


}
