package projetoBiblioteca;

public class Titulo {
	int prazo;
	String isbn;
	int edicao;
	int ano;
	
	public Titulo(int codigo) {
		this.prazo = codigo + 1;
	}
	
	public int getPrazo() {
		return prazo;
	}
	
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
}