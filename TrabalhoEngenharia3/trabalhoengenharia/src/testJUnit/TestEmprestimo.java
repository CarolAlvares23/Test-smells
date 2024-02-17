package testJUnit;

import projetoBiblioteca.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestEmprestimo {
    private static final int LIMITE_LIVROS = 5;
    private Emprestimo emprestimo;
    private Date now;
    private Calendar calendar;

    @BeforeEach
    void setUp() {
        emprestimo = new Emprestimo();
        now = new Date(System.currentTimeMillis());
        calendar = Calendar.getInstance();
        calendar.setTime(now);
    }

    @Test
    void testEmpresta1LivroNaoAplicaDataExtra() {
        List<Livro> livros = criaLivros(1);
        emprestaELancaExcecaoSeNecessario(livros);
        verificaDataDevolucao(2, 0);
    }

    @Test
    void testEmpresta2LivrosNaoAplicaDataExtra() {
        List<Livro> livros = criaLivros(2);
        emprestaELancaExcecaoSeNecessario(livros);
        verificaDataDevolucao(2, 1);
    }

    @Test
    void testEmpresta3LivrosAplicaDataExtra() {
        List<Livro> livros = criaLivros(3);
        emprestaELancaExcecaoSeNecessario(livros);
        verificaDataDevolucao(5, 2);
    }

    @Test
    void testEmpresta4LivrosAplicaDataExtra() {
        List<Livro> livros = criaLivros(4);
        emprestaELancaExcecaoSeNecessario(livros);
        verificaDataDevolucao(8, 3);
    }

    @Test
    void testEmpresta5LivrosAplicaDataExtra() {
        List<Livro> livros = criaLivros(5);
        emprestaELancaExcecaoSeNecessario(livros);
        verificaDataDevolucao(11, 4);
    }

    @Test
    void testNaoEmprestaMaisDe5Livros() {
        List<Livro> livros = criaLivros(LIMITE_LIVROS + 1);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            emprestimo.emprestar(livros);
        });
        Assertions.assertEquals("O limite maximo de livros que pode ser emprestado e " + LIMITE_LIVROS, thrown.getMessage());
    }

    private List<Livro> criaLivros(int quantidade) {
        List<Livro> livros = new ArrayList<Livro>();  
        for(int i = 0; i < quantidade; i++) {
            Livro l = new Livro(i);
            livros.add(l);
        }
        return livros;
    }

    private void emprestaELancaExcecaoSeNecessario(List<Livro> livros) {
        try {
            emprestimo.emprestar(livros);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void verificaDataDevolucao(int dias, int indiceItem) {
        calendar.add(Calendar.DAY_OF_MONTH, dias);
        Item ultimoItem = emprestimo.item.get(indiceItem);
        assertEquals(calendar.getTime().getDay(), ultimoItem.dataDevolucao.getDay(), "A data de devolução do item " + indiceItem + " está incorreta");
    }
}
