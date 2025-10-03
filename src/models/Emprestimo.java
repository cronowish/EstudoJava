package models;

import java.time.LocalDate;
import utils.DataUtils;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = DataUtils.calcularDataDevolucao(usuario);
    }

    public Usuario getUsuario() { return usuario; }
    public Livro getLivro() { return livro; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }

    @Override
    public String toString() {
        return usuario.getNome() + " pegou \"" + livro.getTitulo() +
                "\" em " + dataEmprestimo + " (devolver até " + dataDevolucao + ")";
    }
}