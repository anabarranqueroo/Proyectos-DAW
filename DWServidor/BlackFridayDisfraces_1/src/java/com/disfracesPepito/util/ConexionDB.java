/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disfracesPepito.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/dbdisfraces?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConexion() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // fuerza la carga del driver
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Conexión establecida!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Error al conectar a la BD: " + e.getMessage());
        }
        return conn;
    }
}
