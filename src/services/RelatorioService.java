package services;

import models.*;

public class RelatorioService {

    public static void gerarRelatorioUsuarios(BibliotecaService biblioteca) {
        System.out.println("\n--- Usuários ---");
        biblioteca.getUsuarios().forEach(System.out::println);
    }

    public static void gerarRelatorioLivros(BibliotecaService biblioteca) {
        System.out.println("\n--- Livros ---");
        biblioteca.getLivros().forEach(System.out::println);
    }

    public static void gerarRelatorioEmprestimos(BibliotecaService biblioteca) {
        System.out.println("\n--- Empréstimos ---");
        biblioteca.getEmprestimos().forEach(System.out::println);
    }
}
