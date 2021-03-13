package com.teste;

public class CalculadoraNova {
	
	// ... varArgs, para suportar mais de dois valores
	public int somar(int ... valores) {
		int soma = 0;
		for(int valor : valores)
			soma += valor; 
		
		return soma;
	}

}
