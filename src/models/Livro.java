package models;

public class Livro {

    private String titulo;
    private String autor;
    private int quantidadeDisponivel;

    public Livro(String titulo, String autor, int quantidadeDisponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getQuantidadeDisponivel() { return quantidadeDisponivel; }

    public void emprestar() {
        quantidadeDisponivel--;
    }

    public void devolver() {
        quantidadeDisponivel++;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (Disponíveis: " + quantidadeDisponivel + ")";
    }
}
