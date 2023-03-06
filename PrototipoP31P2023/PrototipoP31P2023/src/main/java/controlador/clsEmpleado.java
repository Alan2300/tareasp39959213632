/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoEmpleado;
/**
 *
 * @author visitante
 */
public class clsEmpleado {
    private int CodigoEmpleado;
    private String NombreEmpleado;
    private String EstatusEmpleado;

    public int getCodigoEmpleado() {
        return CodigoEmpleado;
    }

    public void setCodigoEmpleado(int CodigoEmpleado) {
        this.CodigoEmpleado = CodigoEmpleado;
    }

    public String getNombreEmpleado() {
        return NombreEmpleado;
    }

    public void setNombreEmpleado(String NombreEmpleado) {
        this.NombreEmpleado = NombreEmpleado;
    }

    public String getEstatusEmpleado() {
        return EstatusEmpleado;
    }

    public void setEstatusEmpleado(String EstatusEmpleado) {
        this.EstatusEmpleado = EstatusEmpleado;
    }

    public clsEmpleado(int CodigoEmpleado, String NombreEmpleado, String EstatusEmpleado) {
        this.CodigoEmpleado = CodigoEmpleado;
        this.NombreEmpleado = NombreEmpleado;
        this.EstatusEmpleado = EstatusEmpleado;
    }

    public clsEmpleado(int CodigoEmpleado, String NombreEmpleado) {
        this.CodigoEmpleado = CodigoEmpleado;
        this.NombreEmpleado = NombreEmpleado;
    }

    public clsEmpleado(int CodigoEmpleado) {
        this.CodigoEmpleado = CodigoEmpleado;
    }

    public clsEmpleado() {
    }

    
    //Metodos de acceso a la capa controlador
    public clsEmpleado getBuscarInformacionUsuarioPorNombre(clsEmpleado empleado)
    {
        daoEmpleado daoEmpleado = new daoEmpleado();
        return daoEmpleado.consultaUsuariosPorNombre(empleado);
    }
    public clsEmpleado getBuscarInformacionUsuarioPorId(clsEmpleado empleado)
    {
        daoEmpleado daoEmpleado = new daoEmpleado();
        return daoEmpleado.consultaUsuariosPorId(empleado);
    }    
    public List<clsEmpleado> getListadoUsuarios()
    {
        daoEmpleado daoEmpleado = new daoEmpleado();
        List<clsEmpleado> listadoEmpleados = daoEmpleado.consultaEmpleados();
        return listadoEmpleados;
    }
    public int setBorrarUsuario(clsEmpleado empleado)
    {
        daoEmpleado daoEmpleado = new daoEmpleado();
        return daoEmpleado.borrarUsuarios(empleado);
    }          
    public int setIngresarUsuario(clsEmpleado empleado)
    {
        daoEmpleado daoEmpleado = new daoEmpleado();
        return daoEmpleado.ingresaUsuarios(empleado);
    }              
    public int setModificarUsuario(clsEmpleado empleado)
    {
        daoEmpleado daoEmpleado = new daoEmpleado();
        return daoEmpleado.actualizaUsuarios(empleado);
    }              
    
}
