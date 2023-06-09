package Personas;

public abstract class Usuarios {
    private  String cedula = "";
    private  String nombre = "";
    private  String correo = "";
    private String telefono = "";
    private  String contrasena = "";

    public Usuarios(String cedula, String nombre, String correo, String telefono, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }

    public Usuarios(String cedula) {
        this(cedula, "", "", "", "");
    }
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena, String contrsenaConfirmacion) {
        if(contrasena.equals(contrsenaConfirmacion)){
            this.contrasena = contrasena;
        }
    }
    public void setContrasenaNueva(String contraseña, String contraseñaConfirmacion, String contrasenaAnterior) {
        if (contrasenaAnterior.equals(contrasena)) {
            setContrasena(contraseña, contraseñaConfirmacion);
        }
    }

    @Override
    public String toString() {
        return this.getCedula() + " <> " + this.getNombre() + " <> " + this.getCorreo() + " <> " + this.getTelefono();
    }
}
