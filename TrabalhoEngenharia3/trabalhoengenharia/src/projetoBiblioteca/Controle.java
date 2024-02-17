package projetoBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Controle {
  public boolean emprestar(String raAluno, int quantLivros, int[] codigos) {
	  boolean retorno = true;
	  
	  Aluno aluno = new Aluno(raAluno);
	  
	  if (!aluno.verficaAluno()) {
		  System.out.println("Aluno InexistenteraAluno");
		  retorno = false;
      }
	  
	  if (!aluno.verificaDebito()) {
		  System.out.println("Aluno em Debito");
		  retorno = false;
      }
	  
	  if(retorno) {   
		  List<Livro> livros = new ArrayList<Livro>();  
	   
          for(int i = 0; i< quantLivros; i++) {  
        	  Livro l = new Livro(codigos[i]); 
              if (!l.verificaLivro()) {
            	  livros.add(l);             	  
              }
           }
		   if (livros.size() > 0) {   
		     retorno = aluno.emprestar(livros);
		     return retorno;
		   }
		   return false;
	  	}
	  	else
		  return retorno;
  	}
}
