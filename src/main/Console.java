package main;

import java.util.Random;
import java.util.Scanner;



public class Console {
	Scanner leitor = new Scanner(System.in);
	private Tabuleiro novoJogo;
	Random gerador = new Random();
	
	
	public void iniciarJogo() {
		String nomeJogador1 = lerTexto("Informe o nome do Jogador 1: ");
		String nomeJogador2 = lerTexto("Informe o nome do Jogador 2: ");
		
		try {
			novoJogo = new Tabuleiro(nomeJogador1, nomeJogador2);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return;
		}
		
		int partida = gerador.nextInt(10);
		Jogador jogadorAtual;

		mostrarCartas(nomeJogador1, nomeJogador2);
		trocarCartas();
		
		
		while(novoJogo.continuarJogo() || (!novoJogo.continuarJogo() && novoJogo.getJogador1().getPontos()==novoJogo.getJogador2().getPontos())) {
			
			if(!novoJogo.continuarJogo() && novoJogo.getJogador1().getPontos()==novoJogo.getJogador2().getPontos()) {
				System.out.println("Uma nova partida começa para encontrar o Vencedor");
				novoJogo.setMatriz(new Carta[3][3]);
				novoJogo.getJogador1().setMao(novoJogo.getNovoBaralho().embaralhar());
				novoJogo.getJogador2().setMao(novoJogo.getNovoBaralho().embaralhar());
				trocarCartas();
			}
			
			
			if(partida%2==0) {
				jogadorAtual = novoJogo.getJogador1();

			}else {
				jogadorAtual = novoJogo.getJogador2();
			}
			
			mostrarCartas(nomeJogador1, nomeJogador2);
			
			System.out.println("Pontuação: "+nomeJogador1+"(J1) - "+novoJogo.getJogador1().getPontos()+" Pontos | "+nomeJogador2+"(J2) - "+novoJogo.getJogador2().getPontos()+" Pontos");
			System.out.println("------ TABULEIRO ATUAL ------");
			System.out.println("-----------------------------");
			imprimirTabuleiro();
			informarCarta(jogadorAtual);
			partida++;
			
			
			
		}
		
		System.out.println("-----------------------------");
		System.out.println("----------VENCEDOR-----------");
		if(novoJogo.getJogador1().getPontos()>novoJogo.getJogador2().getPontos()) {
		System.out.println("->->-> "+nomeJogador1+" <-<-<-");
		System.out.println("COM "+novoJogo.getJogador1().getPontos()+" PONTOS");
		
		}else {
			System.out.println("->->-> "+nomeJogador2+" <-<-<-");
			System.out.println("COM "+novoJogo.getJogador2().getPontos()+" PONTOS");
		}
		
		System.out.println("-----------------------------");
	}
	
	private void mostrarCartas(String nome1, String nome2) {
		System.out.println("Cartas JOGADOR "+nome1 + ": ");
		System.out.println("----------------------------");
		for(int i = 0; i<novoJogo.getJogador1().contarCartasNaMao(); i++) {
			System.out.println(novoJogo.getJogador1().getMao().get(i));
		}
		
		System.out.println("Cartas JOGADOR "+nome2 + ": ");
		System.out.println("----------------------------");
		for(int i = 0; i<novoJogo.getJogador2().contarCartasNaMao(); i++) {
			System.out.println(novoJogo.getJogador2().getMao().get(i));
		}
		
	}
	
	private void trocarCartas() {
		Carta carta1 = null;
		Carta carta2 = null;
	    while (carta1 == null) {
	        String nomeCarta1 = lerTexto(novoJogo.getJogador1().getNome() + ", informe o NOME da carta que deseja pegar: ");
	        carta1 = novoJogo.getJogador2().procurarCarta(nomeCarta1);
	        if (carta1 == null) {
	            System.out.println("Carta inválida. Digite o nome corretamente.");
	        }
	    }
	    while (carta2 == null) {
	        String nomeCarta2 = lerTexto(novoJogo.getJogador2().getNome() + ", informe o NOME da carta que deseja pegar: ");
	        carta2 = novoJogo.getJogador1().procurarCarta(nomeCarta2);
	        if (carta2 == null) {
	            System.out.println("Carta inválida. Digite o nome corretamente.");
	        }
	    }
	    
	    novoJogo.getJogador1().getMao().remove(carta2);
	    novoJogo.getJogador2().getMao().remove(carta1);
	    
	    novoJogo.getJogador1().getMao().add(carta1);
	    novoJogo.getJogador2().getMao().add(carta2);
	    
	    novoJogo.atribuirDono();
	}
	
	private void imprimirTabuleiro() {
		System.out.println();
        System.out.println("     0    1    2");
        for (int i = 0; i < 3; i++) {
        	System.out.println(i);
            for (int j = 0; j < 3; j++) {
                if (novoJogo.getMatriz()[i][j] == null) {
                    System.out.print("       ");
                } else {
                    System.out.print("   "+ novoJogo.getMatriz()[i][j].cima + "   ");
                }
                
            }
            
            System.out.println();

            
            for (int j = 0; j < 3; j++) {
                if (novoJogo.getMatriz()[i][j] == null) {
                    System.out.print("       ");
                } else {
                    Carta c = novoJogo.getMatriz()[i][j];
                    System.out.print(c.esquerdo + "[" + c.dono + "]" + c.direito+" ");
                }
                
            }
            System.out.println();

            
            for (int j = 0; j < 3; j++) {
                if (novoJogo.getMatriz()[i][j] == null) {
                    System.out.print("       ");
                } else {
                	System.out.print("   "+ novoJogo.getMatriz()[i][j].baixo + "   ");
                }
               
            }
            System.out.println();

         
            if (i < 2) {
                System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
            }
        }
        System.out.println();
	    }
	
	private boolean informarCarta(Jogador jogadorAtual) {
	    while (true) {
	        String personagem = lerTexto(jogadorAtual.getNome() + " informe o NOME da carta: ");
	        Carta cartaJogador = jogadorAtual.procurarCarta(personagem);
	        
	        if (cartaJogador != null) {
	            int linha = lerInteiro(jogadorAtual.getNome() + " informe a LINHA (0 a 2): ");
	            int coluna = lerInteiro(jogadorAtual.getNome() + " informe a COLUNA (0 a 2): ");
	            
	           
	            if (novoJogo.colocarCarta(cartaJogador, linha, coluna)) {
	            	jogadorAtual.getMao().remove(cartaJogador);
	            	
	            	int capturas = novoJogo.verificarCapturas(linha, coluna, cartaJogador.dono);
	            	
	            	if(jogadorAtual == novoJogo.getJogador1()) {
	            		novoJogo.getJogador2().setPontos(novoJogo.getJogador2().getPontos()- capturas);
	            	}else {
	            		novoJogo.getJogador1().setPontos(novoJogo.getJogador1().getPontos()- capturas);
	            	}
	            	
	            	jogadorAtual.setPontos(jogadorAtual.getPontos()+capturas);
	            	
	                return true; 
	            } else {
	                System.out.println("Posição inválida ou já ocupada no tabuleiro!");
	            }
	        } else {
	            System.out.println("Informe uma carta válida.");
	        }
	    }
	}
	
	
	private int lerInteiro(String mensagem) {
		while (true) {
			System.out.print(mensagem);
			String entrada = leitor.nextLine();

			try {
				return Integer.parseInt(entrada);

			} catch (NumberFormatException e) {
				System.out.println("Digite um numero inteiro valido.");
			}
		}
	}

	private String lerTexto(String mensagem) {
		System.out.print(mensagem);
		return leitor.nextLine();
	}
	
	
	
}
