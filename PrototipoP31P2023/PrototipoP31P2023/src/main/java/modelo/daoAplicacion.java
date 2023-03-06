/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsAplicacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoAplicacion {

    private static final String SQL_SELECT = "SELECT aplid, aplnombre, aplestatus FROM tbl_aplicaciones";
    private static final String SQL_INSERT = "INSERT INTO tbl_aplicaciones(aplnombre, aplestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_aplicaciones SET aplnombre=?, aplestatus=? WHERE aplid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_aplicaciones WHERE aplid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT aplid, aplnombre, aplestatus FROM tbl_aplicaciones WHERE aplnombre = ?";
    private static final String SQL_SELECT_ID = "SELECT aplid, aplnombre, aplestatus FROM tbl_aplicaciones WHERE aplid = ?";    

    public List<clsAplicacion> consultaAplicaciones() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsAplicacion> aplicaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idAp = rs.getInt("aplid");
                String nombreAp = rs.getString("aplnombre");
                String estatus = rs.getString("aplestatus");
                clsAplicacion aplicacion = new clsAplicacion();
                aplicacion.setIdAplicacion(idAp);
                aplicacion.setNombreAplicacion(nombreAp);
                aplicacion.setEstatusAplicacion(estatus);
                aplicaciones.add(aplicacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return aplicaciones;
    }

    public int ingresarAplicaciones(clsAplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, aplicacion.getNombreAplicacion());
            stmt.setString(2, aplicacion.getEstatusAplicacion());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaAplicaciones(clsAplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, aplicacion.getNombreAplicacion());
            stmt.setString(2, aplicacion.getEstatusAplicacion());
            stmt.setInt(3, aplicacion.getIdAplicacion());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarAplicaciones(clsAplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getIdAplicacion());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsAplicacion consultaAplicacionesPorNombre(clsAplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + aplicacion);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idAp = rs.getInt("aplid");
                String nombreAp = rs.getString("aplnombre");
                String estatus = rs.getString("aplestatus");

                //usuario = new clsUsuario();
                aplicacion.setIdAplicacion(idAp);
                aplicacion.setNombreAplicacion(nombreAp);
                aplicacion.setEstatusAplicacion(estatus);
                System.out.println(" registro consultado: " + aplicacion);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return aplicacion;
    }
    public clsAplicacion consultaAplicacionesPorId(clsAplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + aplicacion);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, aplicacion.getIdAplicacion());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idAp = rs.getInt("usuid");
                String nombreAp = rs.getString("usunombre");
                String estatus = rs.getString("usucontrasena");

                //usuario = new clsUsuario();
                aplicacion.setIdAplicacion(idAp);
                aplicacion.setNombreAplicacion(nombreAp);
                aplicacion.setEstatusAplicacion(estatus);
                System.out.println(" registro consultado: " + aplicacion);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return aplicacion;
    }    
}
