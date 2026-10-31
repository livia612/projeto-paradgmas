package main;

import java.util.Scanner;



public class Console {
	Scanner leitor = new Scanner(System.in);
	private Tabuleiro novoJogo = new Tabuleiro();
	
	
	public void iniciarJogo() {
		String nomeJogador1 = lerTexto("Informe o nome do Jogador 1: ");
		String nomeJogador2 = lerTexto("Informe o nome do Jogador 2: ");
		novoJogo.cadastrarJogadores(nomeJogador1, nomeJogador2);
		int partida = 0;
		Jogador jogadorAtual;


		
		while(novoJogo.continuarJogo()) {
			System.out.println("Cartas JOGADOR "+nomeJogador1 + ": ");
			System.out.println("----------------------------");
			for(int i = 0; i<novoJogo.getJogador1().contarCartasNaMao(); i++) {
				System.out.println(novoJogo.getJogador1().getMao().get(i));
			}
			
			System.out.println("Cartas JOGADOR "+nomeJogador2 + ": ");
			System.out.println("----------------------------");
			for(int i = 0; i<novoJogo.getJogador2().contarCartasNaMao(); i++) {
				System.out.println(novoJogo.getJogador2().getMao().get(i));
			}
			System.out.println("Pontuação: "+nomeJogador1+"(J1) - "+novoJogo.getJogador1().getPontos()+" Pontos | "+nomeJogador2+"(J2) - "+novoJogo.getJogador2().getPontos()+" Pontos");
			System.out.println("------ TABULEIRO ATUAL ------");
			System.out.println("-----------------------------");
			
			
			if(partida%2==0) {
				jogadorAtual = novoJogo.getJogador1();

			}else {
				jogadorAtual = novoJogo.getJogador2();
			}
			imprimirTabuleiro();
			informarCarta(jogadorAtual);
			partida++;
			
			
		}
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
	            	novoJogo.verificarCapturas(linha, coluna, jogadorAtual.getNome());
	                return true; 
	            } else {
	                System.out.println("Posição inválida ou já ocupada no tabuleiro! Tente novamente.");
	            }
	        } else {
	            System.out.println("Carta não encontrada na sua mão. Informe uma carta válida.");
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
