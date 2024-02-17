package projetoBiblioteca;

import java.util.List;

public class Aluno {
	String RA;
	String CPF;
	String endereco;

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	

	public Aluno(String nome) {
		super();
		this.RA = nome;
	}
	
	public String getNome() {
		return RA;
	}
	
	public void setNome(String nome) {
		this.RA = nome;
	}
	
	public boolean verficaAluno() {   
		if(this.RA.equals("10"))
			return false;
		else
			return true;
	}
	
	public boolean verificaDebito() {       
	    Debito debito = new Debito(Integer.parseInt(this.RA)); 
		boolean verificandoDebito = debito.verificaDebito();
		return verificandoDebito;
	}
	
	public boolean emprestar(List<Livro> livros) {  
		Emprestimo emprestimo = new Emprestimo();
		boolean emprestando = emprestimo.emprestar(livros);
		return emprestando;
	}
}
