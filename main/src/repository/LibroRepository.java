package repository;

import model.Libro;

import java.util.*;

public class LibroRepository implements Repository<Libro, String> {

    private Map<String, Libro> data = new HashMap<>();

    @Override
    public void save(Libro libro) {
        data.put(libro.getIsbn(), libro);
    }

    @Override
    public Optional<Libro> findById(String isbn) {
        return Optional.ofNullable(data.get(isbn));
    }

    @Override
    public List<Libro> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void delete(String isbn) {
        data.remove(isbn);
    }
}