package Personas;

public class Secretarios extends Usuarios{

   public Secretarios(String cedula, String nombre, String correo, String telefono, String contrasena) {
       super(cedula, nombre, correo, telefono, contrasena);
   }
   public Secretarios(String cedula){
         super(cedula);
   }
}
