/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blackfriday.dao;

import java.sql.*;
import java.util.*;
import com.blackfriday.modelo.Producto;
import com.blackfriday.util.ConexionDB;
import java.sql.Date;

public class ProductoDAO {

    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos ORDER BY fecha_inicio DESC, id DESC";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public Producto buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM productos WHERE id=?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? mapear(rs) : null;
            }
        }
    }

    public boolean insertar(Producto p) throws SQLException {
        String sql = "INSERT INTO productos (nombre, precio, descuento, categoria, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getDescuento());
            ps.setString(4, p.getCategoria());
            ps.setDate(5, p.getFechaInicio() != null ? Date.valueOf(p.getFechaInicio()) : null);
            ps.setDate(6, p.getFechaFin() != null ? Date.valueOf(p.getFechaFin()) : null);
         
            return ps.executeUpdate() == 1;
        }
    }

    public boolean actualizar(Producto p) throws SQLException {
        String sql = "UPDATE productos SET nombre=?, precio=?, descuento=?, categoria=?, fecha_inicio=?, fecha_fin=? WHERE id=?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getDescuento());
            ps.setString(4, p.getCategoria());
            ps.setDate(5, p.getFechaInicio() != null ? Date.valueOf(p.getFechaInicio()) : null);
            ps.setDate(6, p.getFechaFin() != null ? Date.valueOf(p.getFechaFin()) : null);
            ps.setInt(7, p.getId());
            return ps.executeUpdate() == 1;
        }
    }

    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id=?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }

    public List<Producto> listarFiltrado(String categoria, boolean soloActivosHoy) {
        List<Producto> lista = new ArrayList<>();
        StringBuilder sb = new StringBuilder("SELECT * FROM productos WHERE 1=1 ");
        List<Object> params = new ArrayList<>();

        if (categoria != null && !categoria.isBlank()) {
            sb.append("AND categoria LIKE ? ");
            params.add("%" + categoria.trim() + "%");
        }
        if (soloActivosHoy) {
            sb.append("AND CURDATE() BETWEEN fecha_inicio AND fecha_fin ");
        }
        sb.append("ORDER BY fecha_inicio DESC, id DESC");

        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sb.toString())) {
            for (int i = 0; i < params.size(); i++) ps.setObject(i + 1, params.get(i));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) lista.add(mapear(rs));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    private Producto mapear(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getInt("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getDouble("precio"));
        p.setDescuento(rs.getInt("descuento"));
        p.setCategoria(rs.getString("categoria"));
        Date fi = rs.getDate("fecha_inicio");
        Date ff = rs.getDate("fecha_fin");
        p.setFechaInicio(fi != null ? fi.toLocalDate()  : null);
        p.setFechaFin(ff != null ? ff.toLocalDate() : null);
        return p;
    }
}