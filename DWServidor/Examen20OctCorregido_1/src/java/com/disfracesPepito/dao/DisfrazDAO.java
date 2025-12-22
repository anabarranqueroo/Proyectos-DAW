/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disfracesPepito.dao;

import com.disfracesPepito.modelo.Disfraz;
import com.disfracesPepito.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author fgarcia
 */
public class DisfrazDAO {
     public boolean insertar(Disfraz d) {
        String sql = "INSERT INTO disfrazes (descripcion, precio, talla, disponibilidad) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, d.getDescripcion());
            ps.setDouble(2, d.getPrecio());
            ps.setString(3, d.getTalla().name());    
            ps.setString(4, d.getD().name()); 
            
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
     }
}
