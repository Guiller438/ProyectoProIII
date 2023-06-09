package Almacenamiento;

import Personas.Cliente;

import javax.swing.*;
import java.util.LinkedList;

public class ListaClientes {
    public static final LinkedList<Cliente> listaClientes;

    static{
        listaClientes = new LinkedList<>();
    }

    public static boolean add(Cliente cliente) {
        return listaClientes.add(cliente);
    }

    public static boolean remove(Cliente cliente) {
        return listaClientes.remove(cliente);
    }

    public static Cliente search(String cedula) {
        for (var cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    public static void setPacientesInJTextArea(JTextArea textArea) {
        StringBuilder pacientesTextArea = new StringBuilder();
        pacientesTextArea.append("Lista de pacientes");
        pacientesTextArea.append("\n\n");
        for (var cliente : listaClientes) {
            pacientesTextArea.append(cliente.toString()).append("\n");
        }
        textArea.setText(pacientesTextArea.toString());
    }
}
