package Almacenamiento;

import Calendario.DateRange;
import Personas.Administrador;
import Personas.Secretarios;
import Personas.Tecnico;
import Personas.Usuarios;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ListaUsuarios {
    private static final Set<Usuarios> listaUsuarios;
    static {
        listaUsuarios = new HashSet<>();
    }

    public static boolean add(Usuarios usuario) {
        return listaUsuarios.add(usuario);
    }

    public static boolean remove(String cedula) {
        return listaUsuarios.remove(new Secretarios(cedula));
    }

    public static boolean contains(String cedula) {
        return listaUsuarios.contains(new Secretarios(cedula));
    }

    public static Usuarios search(String cedula) {
        for (Usuarios usuario : listaUsuarios) {
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }
        return null;
    }
    public static Set<Tecnico> searchDoctorPorNombre(String nombre) {
        Set<Tecnico> doctores = new TreeSet<>();
        for (Usuarios usuario : listaUsuarios) {
            if (usuario instanceof Tecnico) {
                if (usuario.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                    doctores.add((Tecnico) usuario);
                }
            }
        }
        return doctores;
    }
    public static Set<Tecnico> searchUsuariosPorNombre(String nombre) {
        Set<Tecnico> usuarios = new TreeSet<>();
        for (Usuarios usuario : listaUsuarios) {
            if (usuario instanceof Tecnico) {
                if (usuario.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                    usuarios.add((Tecnico) usuario);
                }
            }
        }
        return usuarios;
    }
    public static Tecnico searchDoctorPorCedula(String cedula) {
        for (Usuarios usuario : listaUsuarios) {
            if (usuario instanceof Tecnico) {
                if (usuario.getCedula().equals(cedula)) {
                    return (Tecnico) usuario;
                }
            }
        }
        return null;
    }
    public static Tecnico searchTecnico(String cedula){
        for (Usuarios usuario : listaUsuarios) {
            if (usuario instanceof Tecnico) {
                if (usuario.getCedula().equals(cedula)) {
                    return (Tecnico) usuario;
                }
            }
        }
        return null;
    }
    public static Set<Tecnico> getDoctores() {
        Set<Tecnico> doctores = new HashSet<>();
        for (Usuarios usuario : listaUsuarios) {
            if (usuario instanceof Tecnico) {
                doctores.add((Tecnico) usuario);
            }
        }
        return doctores;
    }
    public static Set<Tecnico> getDoctoresDisponibles(DateRange rango) {
        Set<Tecnico> doctores = new HashSet<>();
        for (Usuarios usuario : listaUsuarios) {
            if (usuario instanceof Tecnico) {
                Tecnico tecnico = (Tecnico) usuario;
                if (tecnico.estaDisponible(rango)) {
                    doctores.add(tecnico);
                }
            }
        }
        return doctores;
    }
    public static void setInJTextArea(JTextArea textArea) {
        StringBuilder usuariosTextArea = new StringBuilder();

        for (Usuarios usuario : listaUsuarios) {
            usuariosTextArea.append(usuario.toString()).append("\n");
        }

        textArea.setText(usuariosTextArea.toString());
    }
    public static void setInJTextAreas(JTextArea secretariosTextArea, JTextArea administradoresTextArea, JTextArea doctoresTextArea) {
        StringBuilder secretariosText = new StringBuilder();
        StringBuilder administradoresText = new StringBuilder();
        StringBuilder doctoresText = new StringBuilder();

        secretariosText.append("Lista de secretarios");
        secretariosText.append("\n\n");
        administradoresText.append("Lista de administradores");
        administradoresText.append("\n\n");
        doctoresText.append("Lista de doctores");
        doctoresText.append("\n\n");

        for (Usuarios usuario : listaUsuarios) {
            if (usuario instanceof Secretarios) {
                secretariosText.append(usuario.toString()).append("\n");
            } else if (usuario instanceof Administrador) {
                administradoresText.append(usuario.toString()).append("\n");
            } else if (usuario instanceof Tecnico) {
                doctoresText.append(usuario.toString()).append("\n");
            }
        }
        secretariosTextArea.setText(secretariosText.toString());
        administradoresTextArea.setText(administradoresText.toString());
        doctoresTextArea.setText(doctoresText.toString());
    }
    public static void setInJTextAreaAdministradores(JTextArea textArea) {
        StringBuilder administradoresTextArea = new StringBuilder();

        administradoresTextArea.append("Lista de administradores");
        administradoresTextArea.append("\n\n");

        for (Usuarios usuario : listaUsuarios) {
            if (usuario instanceof Administrador) {
                administradoresTextArea.append(usuario.toString()).append("\n");
            }
        }

        textArea.setText(administradoresTextArea.toString());
    }

    public static void setInJTextAreaDoctoresPorNombre(JTextArea textArea, String nombre) {
        StringBuilder doctoresTextArea = new StringBuilder();

        doctoresTextArea.append("Lista de doctores");
        doctoresTextArea.append("\n\n");

        for (Usuarios usuario : listaUsuarios) {
            if (usuario instanceof Tecnico) {
                if (usuario.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                    doctoresTextArea.append(usuario.toString()).append("\n");
                }
            }
        }

        textArea.setText(doctoresTextArea.toString());
    }

    public static void setInJTextAreaUsuariosPorNombre(JTextArea textArea, String nombre) {
        StringBuilder usuariosTextArea = new StringBuilder();

        usuariosTextArea.append("Lista de usuarios");
        usuariosTextArea.append("\n\n");

        for (Usuarios usuario : listaUsuarios) {
            if (usuario.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                usuariosTextArea.append(usuario.toString()).append("\n");
            }
        }

        textArea.setText(usuariosTextArea.toString());
    }

    public static void setInJTextAreaDoctoresDisponibles(JTextArea textArea, DateRange rango) {
        StringBuilder doctoresTextArea = new StringBuilder();

        doctoresTextArea.append("Lista de doctores disponibles");
        doctoresTextArea.append("\n\n");

        for (Usuarios usuario : listaUsuarios) {
            if (usuario instanceof Tecnico) {
                Tecnico doctor = (Tecnico) usuario;
                if (doctor.estaDisponible(rango)) {
                    doctoresTextArea.append(usuario.toString()).append("\n");
                }
            }
        }
        textArea.setText(doctoresTextArea.toString());
    }








}
