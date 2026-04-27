package service;

import model.*;
import repository.*;

import java.util.List;

public class PrestamoService {

    private PrestamoRepository prestamoRepository;
    private LibroRepository libroRepository;
    private UsuarioRepository usuarioRepository;

    public PrestamoService(
            PrestamoRepository prestamoRepository,
            LibroRepository libroRepository,
            UsuarioRepository usuarioRepository) {
        this.prestamoRepository = prestamoRepository;
        this.libroRepository = libroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void prestarLibro(String usuarioId, String isbn) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Libro libro = libroRepository.findById(isbn)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        long prestamosActuales = prestamoRepository.findAll().stream()
                .filter(p -> p.getUsuario().getId().equals(usuarioId))
                .count();

        if (prestamosActuales >= usuario.getLimitePrestamos()) {
            throw new RuntimeException("Límite de préstamos alcanzado");
        }

        Prestamo prestamo = new Prestamo(usuario, libro);
        prestamoRepository.save(prestamo);
    }

    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }
}