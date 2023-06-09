package Almacenamiento;

import Calendario.Cita;


import javax.swing.*;
import java.util.Set;
import java.util.TreeSet;

public class ListaCitas {
    private static final Set<Cita> listaCitas;

    static{
        listaCitas = new TreeSet<>();
    }
    public static boolean add(Cita cita) {
        return listaCitas.add(cita);
    }

    public static boolean remove(int id) {
        return listaCitas.remove(new Cita(id));
    }

    public static boolean contains(int id) {
        return listaCitas.contains(new Cita(id));
    }

    public static Cita search(int id) {
        for (var cita : listaCitas) {
            if (cita.getId() == id) {
                return cita;
            }
        }
        return null;
    }
    public static void setInJTextArea(JTextArea textArea) {
        StringBuilder citasTextArea = new StringBuilder();
        citasTextArea.append("Lista de citas");
        citasTextArea.append("\n\n");

        for (Cita cita : ListaCitas.listaCitas) {
            citasTextArea.append(cita.toString()).append("\n");
        }

        textArea.setText(citasTextArea.toString());
    }

}
