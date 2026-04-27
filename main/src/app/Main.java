package app;

import model.*;
import repository.*;
import service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Repositorios
        LibroRepository libroRepo = new LibroRepository();
        UsuarioRepository usuarioRepo = new UsuarioRepository();
        PrestamoRepository prestamoRepo = new PrestamoRepository();

        // Servicios
        LibroService libroService = new LibroService(libroRepo);
        UsuarioService usuarioService = new UsuarioService(usuarioRepo);
        PrestamoService prestamoService = new PrestamoService(prestamoRepo, libroRepo, usuarioRepo);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== BiblioTech ===");
            System.out.println("1. Agregar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Listar préstamos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            try {
                switch (opcion) {

                    case 1:
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();

                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();

                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();

                        Libro libro = new LibroFisico(isbn, titulo, autor, 2024, "General");
                        libroService.agregarLibro(libro);

                        System.out.println("Libro agregado.");
                        break;

                    case 2:
                        System.out.print("ID usuario: ");
                        String id = scanner.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        Usuario usuario = new Estudiante(id, nombre);
                        usuarioService.registrarUsuario(usuario);

                        System.out.println("Usuario registrado.");
                        break;

                    case 3:
                        System.out.print("ID usuario: ");
                        String userId = scanner.nextLine();

                        System.out.print("ISBN libro: ");
                        String libroId = scanner.nextLine();

                        prestamoService.prestarLibro(userId, libroId);

                        System.out.println("Préstamo realizado.");
                        break;

                    case 4:
                        for (Prestamo p : prestamoService.listarPrestamos()) {
                            System.out.println(
                                    p.getUsuario().getNombre() + " -> " +
                                            p.getLibro().titulo()
                            );
                        }
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 0);

        scanner.close();
    }
}