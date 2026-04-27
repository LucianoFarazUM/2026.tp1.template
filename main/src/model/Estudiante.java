package model;

public class Estudiante extends Usuario {

    public Estudiante(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public int getLimitePrestamos() {
        return 3;
    }
}