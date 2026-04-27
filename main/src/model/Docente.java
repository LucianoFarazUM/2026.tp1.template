package model;

public class Docente extends Usuario {

    public Docente(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public int getLimitePrestamos() {
        return 5;
    }
}