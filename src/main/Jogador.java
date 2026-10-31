package main;
import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private String nome;
	private int pontos;
	private ArrayList<Carta> mao;
	

	public Jogador(String nome, ArrayList<Carta> mao) {
		this.nome = nome;
		this.pontos = 5;
		this.mao = mao;
	}
	
	public Carta procurarCarta(String nomeProcurado) {
		Carta carta = null;
		for(int i = 0; i<mao.size(); i++) {
			if (mao.get(i).nome.equalsIgnoreCase(nomeProcurado)) {
				carta = mao.get(i);
			}
		}
		return carta;
	}
	
	 public int contarCartasNaMao(){
		 return mao.size();
	 }

	 public ArrayList<Carta> getMao() {
		 return mao;
	 }

	 public int getPontos() {
		 return pontos;
	 }

	 public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	 public String getNome() {
		 return nome;
	 }
	 

	 


	 


	 
	
	
}
