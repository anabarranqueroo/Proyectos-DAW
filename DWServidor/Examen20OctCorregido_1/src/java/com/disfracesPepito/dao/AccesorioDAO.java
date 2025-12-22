/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disfracesPepito.dao;

import com.disfracesPepito.modelo.Accesorio;
import com.disfracesPepito.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author fgarcia
 */
public class AccesorioDAO {
     public boolean insertar(Accesorio a) {
        String sql = "INSERT INTO accesorios (nombre, precio) VALUES (?, ?)";
        try (Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            ps.setDouble(2, a.getPrecio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
     }
}
