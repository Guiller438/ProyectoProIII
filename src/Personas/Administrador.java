package Personas;

public class Administrador extends Usuarios{

   public Administrador(String cedula, String nombre, String correo, String telefono, String contrasena) {
       super(cedula, nombre, correo, telefono, contrasena);
   }
   public Administrador(String cedula){
         super(cedula);
   }

}
