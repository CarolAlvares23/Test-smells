package testJUnit;

import projetoBiblioteca.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestControler {
    private static final String RA_VALIDO = "123";
    private static final String RA_INVALIDO = "10";
    private static final String RA_COM_DEBITO = "4";
    private static final int[] PRAZOS_VALIDOS = {1,3,5,6};
    private static final int[] PRAZOS_COM_LIVRO_NAO_VERIFICADO = {1,0,99};
    private static final int[] PRAZOS_SO_COM_LIVROS_NAO_VERIFICADOS = {0,99};
    private Controle controle;

    @BeforeEach
    void setUp() {
        controle = new Controle();
    }

    @Test
    void testNaoEmprestaLivrosParaAlunoNaoVerificado() {
        Aluno aluno = new Aluno(RA_INVALIDO);
        assertFalse("O aluno não deveria ser verificado", aluno.verficaAluno());
        assertFalse("Não deveria emprestar para aluno não verificado", controle.emprestar(RA_INVALIDO, PRAZOS_VALIDOS.length, PRAZOS_VALIDOS));
    }

    @Test
    void testNaoEmprestaLivrosParaAlunoComDebito() {
        Aluno aluno = new Aluno(RA_COM_DEBITO);
        assertFalse("O aluno não deveria ter débito", aluno.verificaDebito());
        assertFalse("Não deveria emprestar para aluno com débito", controle.emprestar(RA_COM_DEBITO, PRAZOS_VALIDOS.length, PRAZOS_VALIDOS));
    }

    @Test
    void testNaoEmprestaLivroNaoVerificado() {
        Livro livro0 = new Livro(1);
        assertFalse("O livro 1 não deveria ser verificado", livro0.verificaLivro());
        Livro livro1 = new Livro(0);
        assertTrue("O livro 0 deveria ser verificado", livro1.verificaLivro());
        Livro livro2 = new Livro(99);
        assertTrue("O livro 99 deveria ser verificado", livro2.verificaLivro());
        assertTrue("Deveria emprestar pelo menos 1 livro verificado", controle.emprestar(RA_VALIDO, PRAZOS_COM_LIVRO_NAO_VERIFICADO.length, PRAZOS_COM_LIVRO_NAO_VERIFICADO));
    }

    @Test
    void testNaoEmprestaNenhumLivroNaoVerificado() {
        Livro livro1 = new Livro(0);
        assertTrue("O livro 0 deveria ser verificado", livro1.verificaLivro());
        Livro livro2 = new Livro(99);
        assertTrue("O livro 99 deveria ser verificado", livro2.verificaLivro());
        assertFalse("Não deveria emprestar nenhum livro não verificado", controle.emprestar(RA_VALIDO, PRAZOS_SO_COM_LIVROS_NAO_VERIFICADOS.length, PRAZOS_SO_COM_LIVROS_NAO_VERIFICADOS));
    }

    @Test
    void testEmprestaLivros() {
        assertTrue("Deveria emprestar todos os livros verificados", controle.emprestar(RA_VALIDO, PRAZOS_VALIDOS.length, PRAZOS_VALIDOS));
    }
}
