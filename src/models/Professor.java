package models;

public class Professor extends Usuario {
    public Professor(String nome, String email) {
        super(nome, email);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 5;
    }
}