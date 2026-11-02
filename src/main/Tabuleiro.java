package main;
public class Tabuleiro {
	private Carta[][] matriz;
	private Baralho novoBaralho;
	private Jogador jogador1;
	private Jogador jogador2;

	
	public Tabuleiro(String nome1, String nome2) throws Exception {
		
		if (nome1 == null || nome1.trim().isEmpty() || nome2 == null || nome2.trim().isEmpty()) {
			throw new Exception("Erro: Os nomes dos jogadores não podem ser vazios ou nulos.");
	    }

	    if (nome1.trim().equalsIgnoreCase(nome2.trim())) {
	    	throw new Exception("Erro: O nome do Jogador 1 não pode ser igual ao do Jogador 2.");
	    }
	    
	    this.matriz = new Carta[3][3];
		this.novoBaralho = new Baralho();
		
		jogador1 = new Jogador(nome1, novoBaralho.embaralhar());
		jogador2 = new Jogador(nome2, novoBaralho.embaralhar());
		atribuirDono();
		
		

	}

	public boolean verificar(int linha, int coluna) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
        	return false;
        }
        if(matriz[linha][coluna] == null) {
        	return true;
        }
        return false;
    }
	
	public boolean colocarCarta(Carta carta, int linha, int coluna) {
        if (verificar(linha, coluna)) {
            matriz[linha][coluna] = carta;
            return true;
        }
        return false;
    }
	
	public boolean continuarJogo() {
		int contador = 0;
		for (int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(matriz[i][j]!= null) {
					contador++;
				}
			}
		}
		if (contador<9) {
			return true;
		}
		return false;
	}
	
	public void atribuirDono() {
		for(int i = 0; i<5; i++) {
			jogador1.getMao().get(i).dono = "J1";
			jogador2.getMao().get(i).dono = "J2";
		}
	}

	 public int verificarCapturas(int linha, int coluna, String dono) {
	        Carta cartaAtual = matriz[linha][coluna];
	        int capturas = 0;

	        if (linha > 0 && matriz[linha - 1][coluna] != null) {
	            Carta vizinha = matriz[linha - 1][coluna];
	            if (!vizinha.dono.equals(dono) && cartaAtual.cima > vizinha.baixo) {
	                vizinha.dono = dono;
	                capturas++;
	                System.out.println("CAPTUROU a carta de CIMA");
	                capturas += verificarCapturas(linha - 1, coluna, dono);
	            }
	        }
	        if (linha < 2 && matriz[linha + 1][coluna] != null) {
	            Carta vizinha = matriz[linha + 1][coluna];
	            if (!vizinha.dono.equals(dono) && cartaAtual.baixo > vizinha.cima) {
	                vizinha.dono = dono;
	                capturas++;
	                System.out.println("CAPTUROU a carta de BAIXO");
	                capturas += verificarCapturas(linha + 1, coluna, dono);
	            }
	        }
	        if (coluna > 0 && matriz[linha][coluna - 1] != null) {
	            Carta vizinha = matriz[linha][coluna - 1];
	            if (!vizinha.dono.equals(dono) && cartaAtual.esquerdo > vizinha.direito) {
	                vizinha.dono = dono;
	                capturas++;
	                System.out.println("CAPTUROU a carta da ESQUERDA");
	                capturas += verificarCapturas(linha, coluna - 1, dono);
	            }
	        }
	        if (coluna < 2 && matriz[linha][coluna + 1] != null) {
	            Carta vizinha = matriz[linha][coluna + 1];
	            if (!vizinha.dono.equals(dono) && cartaAtual.direito > vizinha.esquerdo) {
	                vizinha.dono = dono;
	                capturas++;
	                System.out.println("CAPTUROU a carta da DIREITA");
	                capturas += verificarCapturas(linha, coluna + 1, dono);
	            }
	        }
	        return capturas;
	    }
	 
	
	
	public Jogador getJogador1() {
		return jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	
	public Carta[][] getMatriz() {
		return matriz;
	}
	

	public Baralho getNovoBaralho() {
		return novoBaralho;
	}

	public void setMatriz(Carta[][] matriz) {
		this.matriz = matriz;
	}


	

	
	
	
	

	
	
	
	

}
