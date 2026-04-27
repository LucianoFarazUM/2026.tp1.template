package model;

public record Ebook(
        String isbn,
        String titulo,
        String autor,
        int anio,
        String categoria,
        double tamañoMB
) implements Libro {}