/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoAplicacion;
/**
 *
 * @author visitante
 */
public class clsAplicacion {

    public int getIdAplicacion() {
        return IdAplicacion;
    }

    public void setIdAplicacion(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public String getNombreAplicacion() {
        return NombreAplicacion;
    }

    public void setNombreAplicacion(String NombreAplicacion) {
        this.NombreAplicacion = NombreAplicacion;
    }

    public String getEstatusAplicacion() {
        return EstatusAplicacion;
    }

    public void setEstatusAplicacion(String EstatusAplicacion) {
        this.EstatusAplicacion = EstatusAplicacion;
    }
    private int IdAplicacion;
    private String NombreAplicacion;
    private String EstatusAplicacion;

    public clsAplicacion(int IdAplicacion, String NombreAplicacion, String EstatusAplicacion) {
        this.IdAplicacion = IdAplicacion;
        this.NombreAplicacion = NombreAplicacion;
        this.EstatusAplicacion = EstatusAplicacion;
    }

    public clsAplicacion(int IdAplicacion, String NombreAplicacion) {
        this.IdAplicacion = IdAplicacion;
        this.NombreAplicacion = NombreAplicacion;
    }

    public clsAplicacion(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public clsAplicacion() {
    }

    
    
    //Metodos de acceso a la capa controlador
    public clsAplicacion getBuscarInformacionAplicacionPorNombre(clsAplicacion aplicacion)
    {
        daoAplicacion daoaplicacion = new daoAplicacion();
        return daoaplicacion.consultaAplicacionesPorNombre(aplicacion);
    }
    public clsAplicacion getBuscarInformacionAplicacionPorId(clsAplicacion aplicacion)
    {
        daoAplicacion daoaplicacion = new daoAplicacion();
        return daoaplicacion.consultaAplicacionesPorId(aplicacion);
    }    
    public List<clsAplicacion> getListadoAplicaciones()
    {
        daoAplicacion daoaplicacion = new daoAplicacion();
        List<clsAplicacion> listadosAplicaciones = daoaplicacion.consultaAplicaciones();
        return listadosAplicaciones;
    }
    public int setBorrarAplicacion(clsAplicacion aplicacion)
    {
        daoAplicacion daoaplicacion = new daoAplicacion();
        return daoaplicacion.borrarAplicaciones(aplicacion);
    }          
    public int setIngresarAplicacion(clsAplicacion aplicacion)
    {
        daoAplicacion daoaplicacion = new daoAplicacion();
        return daoaplicacion.ingresarAplicaciones(aplicacion);
    }              
    public int setModificarAplicacion(clsAplicacion aplicacion)
    {
        daoAplicacion daoaplicacion = new daoAplicacion();
        return daoaplicacion.actualizaAplicaciones(aplicacion);
    }              
}
