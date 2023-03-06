/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsEmpleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoEmpleado {

    private static final String SQL_SELECT = "SELECT codigo_empleado, nombre_empleado, estatus_empleado FROM empleado";
    private static final String SQL_INSERT = "INSERT INTO empleado(nombre_empleado, estatus_empleado) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE empleado SET nombre_empleado=?, estatus_empleado=? WHERE codigo_empleado = ?";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE codigo_empleado=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_empleado, nombre_empleado, estatus_empleado FROM empleado WHERE nombre_empleado = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_empleado, nombre_empleado, estatus_empleado FROM empleado WHERE codigo_empleado = ?";    

    public List<clsEmpleado> consultaEmpleados() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsEmpleado> empleados = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_empleado");
                String nombre = rs.getString("nombre_empleado");
                String estatus = rs.getString("estatus_empleado");
                clsEmpleado empleado = new clsEmpleado();
                empleado.setCodigoEmpleado(codigo);
                empleado.setNombreEmpleado(nombre);
                empleado.setEstatusEmpleado(estatus);
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return empleados;
    }

    public int ingresaUsuarios(clsEmpleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getNombreEmpleado());
            stmt.setString(2, empleado.getEstatusEmpleado());

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

    public int actualizaUsuarios(clsEmpleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getNombreEmpleado());
            stmt.setString(2, empleado.getEstatusEmpleado());
            stmt.setInt(3, empleado.getCodigoEmpleado());

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

    public int borrarUsuarios(clsEmpleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getCodigoEmpleado());
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

    public clsEmpleado consultaUsuariosPorNombre(clsEmpleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + empleado);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, empleado.getNombreEmpleado());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String estatus = rs.getString("usucontrasena");

                //usuario = new clsUsuario();
                empleado.setCodigoEmpleado(codigo);
                empleado.setNombreEmpleado(nombre);
                empleado.setEstatusEmpleado(estatus);
                System.out.println(" registro consultado: " + empleado);                
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
        return empleado;
    }
    public clsEmpleado consultaUsuariosPorId(clsEmpleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + empleado);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, empleado.getCodigoEmpleado());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String estatus = rs.getString("usucontrasena");

                //usuario = new clsUsuario();
                empleado.setCodigoEmpleado(codigo);
                empleado.setNombreEmpleado(nombre);
                empleado.setEstatusEmpleado(estatus);                
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
        return empleado;
    }    
}
