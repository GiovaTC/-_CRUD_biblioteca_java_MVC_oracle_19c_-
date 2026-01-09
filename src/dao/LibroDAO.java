package dao;

import model.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public void insertar(Libro libro) {
        String sql = "INSERT INTO LIBRO (TITULO, AUTOR, ANIO) VALUES (?, ?, ?)";
        try (Connection con = ConexionOracle.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnio());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Libro> listar() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM LIBRO";

        try (Connection con = ConexionOracle.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Libro l = new Libro();
                l.setId(rs.getInt("ID"));
                l.setTitulo(rs.getString("TITULO"));
                l.setAutor(rs.getString("AUTOR"));
                l.setAnio(rs.getInt("ANIO"));
                libros.add(l);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return libros;
    }

    public void actualizar(Libro libro) {
        String sql =
                "UPDATE LIBRO SET TITULO = ?, AUTOR = ?, ANIO = ? WHERE ID = ?";
        try (Connection con = ConexionOracle.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnio());
            ps.setInt(4, libro.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM LIBRO WHERE ID = ?";
        try (Connection con = ConexionOracle.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
