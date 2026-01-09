package controller;

import dao.LibroDAO;
import model.Libro;
import java.util.List;

public class LibroController {

    private final LibroDAO dao = new LibroDAO();

    public void agregarLibro(String titulo, String autor, int anio) {
        dao.insertar(new Libro(titulo, autor, anio));
    }

    public List<Libro> obtenerLibros() {
        return dao.listar();
    }

    public void actualizarLibro(int id, String titulo, String autor, int anio) {
        Libro l = new Libro(titulo, autor, anio);
        l.setId(id);
        dao.actualizar(l);
    }

    public void eliminarLibro(int id) {
        dao.eliminar(id);
    }
}   
