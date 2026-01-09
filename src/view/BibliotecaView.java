package view;

import controller.LibroController;
import model.Libro;
import java.util.Scanner;

public class BibliotecaView {

    private final LibroController controller = new LibroController();
    private final Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion;

        do {
            System.out.println("\n--- BIBLIOTECA ---");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Listar Libros");
            System.out.println("3. Actualizar Libro");
            System.out.println("4. Eliminar Libro");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> listar();
                case 3 -> actualizar();
                case 4 -> eliminar();
            }
        } while (opcion != 0);
    }
    private void agregar() {
        System.out.print("Título: ");
        String t = sc.nextLine();
        System.out.print("Autor: ");
        String a = sc.nextLine();
        System.out.print("Año: ");
        int y = sc.nextInt();
        controller.agregarLibro(t, a, y);
    }

    private void listar() {
        for (Libro l : controller.obtenerLibros()) {
            System.out.println(
                    l.getId() + " | " + l.getTitulo() + " | " +
                            l.getAutor() + " | " + l.getAnio()
            );
        }
    }

    private void actualizar() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo título: ");
        String t = sc.nextLine();
        System.out.print("Nuevo autor: ");
        String a = sc.nextLine();
        System.out.print("Nuevo año: ");
        int y = sc.nextInt();
        controller.actualizarLibro(id, t, a, y);
    }

    private void eliminar() {
        System.out.print("ID a eliminar: ");
        controller.eliminarLibro(sc.nextInt());
    }
}   
