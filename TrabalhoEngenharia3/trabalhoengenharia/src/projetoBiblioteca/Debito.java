package projetoBiblioteca;

import java.util.Date;

public class Debito {
	int codigoAluno;
	float valor;
	Date data = new Date();
	
	public Debito(int aluno) {
		this.codigoAluno = aluno;
	}
	
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean verificaDebito() {
		if(this.codigoAluno == 4)
			 return false;
		 else
			return true;
	}
}