/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disfracesPepito.dao;

import java.sql.*;
import java.util.*;
import com.disfracesPepito.modelo.Disfraz;
import com.disfracesPepito.util.ConexionDB;
import com.disfracesPepito.modelo.Disponibilidad;
import com.disfracesPepito.modelo.Talla;

public class DisfrazDAO {

    public List<Disfraz> listar() {
        List<Disfraz> lista = new ArrayList<>();
        String sql = "SELECT * FROM disfraces2 ORDER BY fecha_inicio DESC, id DESC";
        try (Connection con = ConexionDB.getConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Disfraz buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM disfraces2 WHERE id=?";
        try (Connection con = ConexionDB.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? mapear(rs) : null;
            }
        }
    }

    public boolean insertar(Disfraz d) throws SQLException {
        String sql = "INSERT INTO disfraces2 (descripcion, precio, talla, disponibilidad,fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, d.getDescripcion());
            ps.setDouble(2, d.getPrecio());
            ps.setString(3, d.getTalla().name());
            ps.setString(4, d.getD().name());
            ps.setDate(5, d.getFecha_inicio() != null ? new java.sql.Date(d.getFecha_inicio().getTime()) : null);
            ps.setDate(6, d.getFecha_fin() != null ? new java.sql.Date(d.getFecha_fin().getTime()) : null);

            return ps.executeUpdate() == 1;
        }
    }

    public boolean actualizar(Disfraz d) throws SQLException {
        String sql = "UPDATE disfraces2 SET descripcion=?, precio=?, talla=?, disponibilidad=?, fecha_inicio=?, fecha_fin=? WHERE id=?";
        try (Connection con = ConexionDB.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, d.getDescripcion());
            ps.setDouble(2, d.getPrecio());
            ps.setString(3, d.getTalla().name());
            ps.setString(4, d.getD().name());
            ps.setDate(5, d.getFecha_inicio() != null ? new java.sql.Date(d.getFecha_inicio().getTime()) : null);
            ps.setDate(6, d.getFecha_fin() != null ? new java.sql.Date(d.getFecha_fin().getTime()) : null);
            ps.setInt(7, d.getId());

            return ps.executeUpdate() == 1;
        }
    }

    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM disfraces2 WHERE id=?";
        try (Connection con = ConexionDB.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }

    public List<Disfraz> listarFiltrado(String talla, String disponibilidad, boolean soloActivosHoy) {
        List<Disfraz> lista = new ArrayList<>();
        StringBuilder sb = new StringBuilder("SELECT * FROM disfraces2 WHERE 1=1 ");
        List<Object> params = new ArrayList<>();

        // Filtro por talla
        if (talla != null && !talla.isBlank()) {
            sb.append("AND talla = ? ");
            params.add(talla.trim());
        }

        // Filtro por disponibilidad
        if (disponibilidad != null && !disponibilidad.isBlank()) {
            sb.append("AND disponibilidad = ? ");
            params.add(disponibilidad.trim());
        }
        if (soloActivosHoy) {
            sb.append("AND CURDATE() BETWEEN fecha_inicio AND fecha_fin ");
        }
        sb.append("ORDER BY fecha_inicio DESC, id DESC");

        try (Connection con = ConexionDB.getConexion(); PreparedStatement ps = con.prepareStatement(sb.toString())) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private Disfraz mapear(ResultSet rs) throws SQLException {
        Disfraz d = new Disfraz();
        d.setId(rs.getInt("id"));
        d.setDescripcion(rs.getString("descripcion"));
        d.setPrecio(rs.getDouble("precio"));
        d.setTalla(Talla.valueOf(rs.getString("talla")));
        d.setD(Disponibilidad.valueOf(rs.getString("disponibilidad")));
        d.setFecha_inicio(rs.getDate("fecha_inicio"));
        d.setFecha_fin(rs.getDate("fecha_fin"));
        return d;
    }

}
