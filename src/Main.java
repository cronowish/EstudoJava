

/*
Versão 1.2 Commit

exemplo de projeto Java um pouco mais complexo, usando várias classes, herança, interfaces e boas práticas.
É um sistema simples de biblioteca com cadastro de usuários, livros, empréstimos e relatórios.
Você pode estudar esse código para entender:
Criação de várias classes em pacotes diferentes.
Uso de interfaces e herança.
Polimorfismo.
Exceções personalizadas.
Organização de código.
CRUD básico em memória.
 */

import models.*;
import services.*;
import exceptions.*;

public class Main {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();

        // Criando usuários
        Usuario u1 = new Estudante("Ana", "ana@email.com");
        Usuario u2 = new Professor("Carlos", "carlos@email.com");

        // Criando livros
        Livro l1 = new Livro("Java Básico", "José Silva", 3);
        Livro l2 = new Livro("Padrões de Projeto", "Gamma et al.", 1);

        // Adicionando no sistema
        biblioteca.adicionarUsuario(u1);
        biblioteca.adicionarUsuario(u2);
        biblioteca.adicionarLivro(l1);
        biblioteca.adicionarLivro(l2);

        try {
            // Empréstimos
            biblioteca.realizarEmprestimo(u1, l1);
            biblioteca.realizarEmprestimo(u2, l2);

            // Esse vai falhar porque só tem 1 exemplar
            biblioteca.realizarEmprestimo(u1, l2);

        } catch (LivroIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Relatórios
        RelatorioService.gerarRelatorioUsuarios(biblioteca);
        RelatorioService.gerarRelatorioLivros(biblioteca);
        RelatorioService.gerarRelatorioEmprestimos(biblioteca);
    }
}