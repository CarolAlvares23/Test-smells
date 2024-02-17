package projetoBiblioteca;

public class Livro {
	int prazo;
	boolean exemplarBiblioteca;
	Titulo titulo;

	public Livro(int codigo) {
		super();
		titulo = new Titulo(codigo);
		if (codigo == 0 || codigo == 99)
			exemplarBiblioteca = true;
		else
			exemplarBiblioteca = false;
	}

	public int verPrazo() {
		return titulo.getPrazo();
	}

	public boolean verificaLivro() {  
		return exemplarBiblioteca;   
	}
}
