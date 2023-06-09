package Personas;

import java.util.Date;

public class Cliente{
    private String cedula;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private Date fechaNacimiento;

    private FichaTecnica fichaTecnica;

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public FichaTecnica getFichaTecnica() {
        return fichaTecnica;
    }

    public Cliente(String cedula, String nombre, String correo, String telefono, String direccion, Date fechaNacimiento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fichaTecnica = new FichaTecnica(this);
    }

    @Override
    public String toString() {
        return nombre + " <> " + cedula + " <> " + telefono + " <> " + correo + " <> " + fechaNacimiento;
    }


}
