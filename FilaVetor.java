package teste;

class Inteiro {

	private int valor;
	
	public Inteiro(int valor) {
		this.valor = valor;
	}

	public Inteiro() {
		valor = 0;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public void imprimir() {
		System.out.println("Valor -> " + valor);
	}
}

class Fila {

	private Inteiro[] fila;
	private int frente;
	private int tras;
	private int tamanho;
	
	public Fila(int tamanho) {
		
		fila = new Inteiro[tamanho];
		frente = 0;
		tras = 0;
		this.tamanho = tamanho;
	}
	
	public boolean filaVazia() {
	
		boolean resp;
		
		if (frente == tras)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public boolean filaCheia() {
	
		boolean resp;
		
		if (((tras + 1) % tamanho) == (frente % tamanho))
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public void enfileirar(Inteiro novo) throws Exception{
		
		int posicao;
		
		if (! filaCheia()) {
			posicao = tras % tamanho;
			fila[posicao] = novo;
			tras++;
		} else
			throw new Exception("Não foi possível enfileirar o novo elemento: a fila está cheia!");
	}
	
	public Inteiro desenfileirar() throws Exception{
		
		Inteiro desenfileirado;
		int posicao;
		
		if (! filaVazia()) {
			posicao = frente % tamanho;
			desenfileirado = fila[posicao];
			frente++;
			return desenfileirado;
		} else
			throw new Exception("Não foi possível desenfileirar nenhum elemento: a fila está vazia!");
	}
	
	public void imprimir() throws Exception{
		
		int posicao;
		if (! filaVazia()) {
			System.out.println("Conteúdo da fila:");
			for (int i = frente; i < tras; i++) {
				posicao = i % tamanho;
				System.out.print("Posição: " + posicao + ": ");
				fila[posicao].imprimir();
			}
		} else
			throw new Exception ("Não foi possível mostrar o conteúdo da fila: a fila está vazia!");
	}
}

class Main {
  public static void main(String[] args) {
    Fila minhaFila;
		Inteiro novo;
		Inteiro desenfileirado;
		
		minhaFila = new Fila(4);
		
		novo = new Inteiro(14);
		try {
			minhaFila.enfileirar(novo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		novo = new Inteiro(10);
		try {
			minhaFila.enfileirar(novo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		novo = new Inteiro(21);
		try {
			minhaFila.enfileirar(novo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		novo = new Inteiro(3);
		try {
			minhaFila.enfileirar(novo);
		} catch (Exception e) {
			System.out.println(e.getMessage());   // Exibe essa mensagem
		}
		
		try {
			minhaFila.imprimir();    // 14 - 10 - 21
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			desenfileirado = minhaFila.desenfileirar();
			System.out.print("Desenfileirado: ");
			desenfileirado.imprimir();    // 14
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		
		try {
			desenfileirado = minhaFila.desenfileirar();
			System.out.print("Desenfileirado: ");
			desenfileirado.imprimir();    // 10
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		
		novo = new Inteiro(3);
		try {
			minhaFila.enfileirar(novo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		novo = new Inteiro(20);
		try {
			minhaFila.enfileirar(novo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			minhaFila.imprimir();    // 21 - 3 - 20
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} 
}