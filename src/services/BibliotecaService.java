package services;

import java.util.ArrayList;
import java.util.List;

import models.*;
import exceptions.*;

public class BibliotecaService {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void realizarEmprestimo(Usuario usuario, Livro livro) throws LivroIndisponivelException {
        if (livro.getQuantidadeDisponivel() <= 0) {
            throw new LivroIndisponivelException("O livro \"" + livro.getTitulo() + "\" não está disponível.");
        }

        long emprestimosUsuario = emprestimos.stream()
                .filter(e -> e.getUsuario().equals(usuario))
                .count();

        if (emprestimosUsuario >= usuario.getLimiteEmprestimos()) {
            throw new LivroIndisponivelException(usuario.getNome() + " já atingiu o limite de empréstimos.");
        }

        livro.emprestar();
        Emprestimo emprestimo = new Emprestimo(usuario, livro);
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo realizado: " + emprestimo);
    }

    public List<Usuario> getUsuarios() { return usuarios; }
    public List<Livro> getLivros() { return livros; }
    public List<Emprestimo> getEmprestimos() { return emprestimos; }
}