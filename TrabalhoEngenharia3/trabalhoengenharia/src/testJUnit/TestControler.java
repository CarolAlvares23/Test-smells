package testJUnit;

import projetoBiblioteca.*;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;


class TestControler {

	@Test
	void testNaoEmprestaLivrosParaAlunoNaoVerificado() {
		String ra = "10";
		Aluno aluno = new Aluno(ra);
		assertFalse(aluno.verficaAluno());

		int[] prazos = {1,2,3};
		Controle c = new Controle();
		boolean retorno = c.emprestar(ra, prazos.length, prazos);
		assertFalse(retorno);
	}

	@Test
	void testNaoEmprestaLivrosParaAlunoComDebito() {
		String ra = "4";
		Aluno aluno = new Aluno(ra);
		assertFalse(aluno.verificaDebito());

		int[] prazos = {1,2,3};
		Controle c = new Controle();
		boolean retorno = c.emprestar(ra, prazos.length, prazos);
		assertFalse(retorno);
	}

	@Test
	void testNaoEmprestaLivroNaoVerificado() {
		String ra = "123";
		int[] prazos = {1,0,99};  // 2 e 4 nao é verificado
		Livro livro0 = new Livro(1);
		assertTrue(!livro0.verificaLivro());
		Livro livro1 = new Livro(0);
		assertFalse(!livro1.verificaLivro());
		Livro livro2 = new Livro(99);
		assertFalse(!livro2.verificaLivro());
		
		Controle c = new Controle();
		boolean retorno = c.emprestar(ra, prazos.length, prazos);
		assertTrue(retorno);  // emprestou só 1 livro
	}

	@Test
	void testNaoEmprestaNenhumLivroNaoVerificado() {
		String ra = "123";
		int[] prazos = {0,99};  // 2 e 4 nao é verificado
		Livro livro1 = new Livro(0);
		assertFalse(!livro1.verificaLivro());
		Livro livro2 = new Livro(99);
		assertFalse(!livro2.verificaLivro());
		
		Controle c = new Controle();
		boolean retorno = c.emprestar(ra, prazos.length, prazos);
		assertFalse(retorno);
	}

	@Test
	void testEmprestaLivros() {
		String ra = "123";
		int[] prazos = {1,3,5,6};
		Controle c = new Controle();
		boolean retorno = c.emprestar(ra, prazos.length, prazos);
		assertTrue(retorno);
	}
}
