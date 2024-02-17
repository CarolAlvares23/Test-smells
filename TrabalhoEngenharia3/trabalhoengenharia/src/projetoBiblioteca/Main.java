package projetoBiblioteca;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		 try (Scanner entrada = new Scanner (System.in)) {
			int[] codigos = {0, 0, 0, 0, 0};
			System.out.print("Digite o RA do Aluno: ");
			String raAluno = entrada.nextLine();
			System.out.print("Digite o numero de Livros a ser emprestado: ");
			int quantLivros = entrada.nextInt();
			int aux;
			for(int i = 0; i < quantLivros; i++) {
				System.out.print("Digite o codigo do livro -- " + (i+1) + ": ");
				aux = entrada.nextInt();
				for (int j = 0; j < codigos.length; j++) {
					if(codigos[j] == aux) {
						System.out.println("Codigo ja adiconado!");
						System.out.print("Digite o codigo do livro -- " + (i+1) + ": ");
						aux = entrada.nextInt();
					}
				}
				codigos[i] = aux;
			 }
			Controle controler = new Controle();
			controler.emprestar(raAluno, quantLivros, codigos);
		} 
    		 
	}

}
