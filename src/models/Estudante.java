package models;

public class Estudante extends Usuario {
    public Estudante(String nome, String email) {
        super(nome, email);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 3;
    }
}