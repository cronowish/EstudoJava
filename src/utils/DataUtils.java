package utils;

import java.time.LocalDate;
import models.Usuario;
import models.Professor;

public class DataUtils {
    public static LocalDate calcularDataDevolucao(Usuario usuario) {
        // Professor tem mais prazo que estudante
        if (usuario instanceof Professor) {
            return LocalDate.now().plusDays(15);
        }
        return LocalDate.now().plusDays(7);
    }
}