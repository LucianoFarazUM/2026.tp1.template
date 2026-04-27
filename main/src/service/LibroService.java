package service;

import model.Libro;
import repository.LibroRepository;

import java.util.List;
import java.util.Optional;

public class LibroService {

    private LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void agregarLibro(Libro libro) {
        libroRepository.save(libro);
    }

    public Optional<Libro> buscarPorIsbn(String isbn) {
        return libroRepository.findById(isbn);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }
}