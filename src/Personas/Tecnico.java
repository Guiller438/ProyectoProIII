package Personas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;


import Calendario.Cita;
import Calendario.DateRange;
import Calendario.Horario;

public class Tecnico extends Usuarios{
    private int citasAtendidas;

    private Horario lunes;
    private Horario martes;
    private Horario miercoles;
    private Horario jueves;
    private Horario viernes;
    private Horario sabado;
    private Horario domingo;

    private final Set<Cita> citasLunes;
    private final Set<Cita> citasMartes;
    private final Set<Cita> citasMiercoles;
    private final Set<Cita> citasJueves;
    private final Set<Cita> citasViernes;
    private final Set<Cita> citasSabado;
    private final Set<Cita> citasDomingo;

    public Tecnico (String cedula, String nombre, String telefono, String correo, String contrasena, Horario lunes, Horario martes, Horario miercoles, Horario jueves, Horario viernes, Horario sabado, Horario domingo){
        super(cedula, nombre, correo, telefono, contrasena);
        this.citasAtendidas = 0;

        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;

        this.citasLunes = new TreeSet<>();
        this.citasMartes = new TreeSet<>();
        this.citasMiercoles = new TreeSet<>();
        this.citasJueves = new TreeSet<>();
        this.citasViernes = new TreeSet<>();
        this.citasSabado = new TreeSet<>();
        this.citasDomingo = new TreeSet<>();
    }

    public Tecnico(String cedula, String nombre, String telefono, String correo, String contrasena, Horario[] horarios) {
        this(cedula, nombre, telefono, correo, contrasena, horarios[0], horarios[1], horarios[2], horarios[3], horarios[4], horarios[5], horarios[6]);
    }

    public Tecnico(String cedula) {
        super(cedula);

        this.citasAtendidas = 0;

        this.citasLunes = null;
        this.citasMartes = null;
        this.citasMiercoles = null;
        this.citasJueves = null;
        this.citasViernes = null;
        this.citasSabado = null;
        this.citasDomingo = null;
    }

    private Horario getDiaSemana(int dia){
        return switch (dia){
            case GregorianCalendar.MONDAY -> this.lunes;
            case GregorianCalendar.TUESDAY -> this.martes;
            case GregorianCalendar.WEDNESDAY -> this.miercoles;
            case GregorianCalendar.THURSDAY -> this.jueves;
            case GregorianCalendar.FRIDAY -> this.viernes;
            case GregorianCalendar.SATURDAY -> this.sabado;
            case GregorianCalendar.SUNDAY -> this.domingo;
            default -> null;
        };
    }

    public Set<Cita> getCitasDelDia(int dia) {
        return switch (dia) {
            case GregorianCalendar.MONDAY -> citasLunes;
            case GregorianCalendar.TUESDAY -> citasMartes;
            case GregorianCalendar.WEDNESDAY -> citasMiercoles;
            case GregorianCalendar.THURSDAY -> citasJueves;
            case GregorianCalendar.FRIDAY -> citasViernes;
            case GregorianCalendar.SATURDAY -> citasSabado;
            case GregorianCalendar.SUNDAY -> citasDomingo;
            default -> null;
        };
    }
    public boolean estaDisponible(DateRange rango) {
        Horario diaConsultado = getDiaSemana(rango.getStart().get(GregorianCalendar.DAY_OF_WEEK));
        Set<Cita> citasDelDia = getCitasDelDia(rango.getStart().get(GregorianCalendar.DAY_OF_WEEK));

        if (diaConsultado == null || citasDelDia == null) {
            return false;
        }

        DateRange horarioAlmuerzo = new DateRange(
                new GregorianCalendar(
                        rango.getStart().get(GregorianCalendar.YEAR),
                        rango.getStart().get(GregorianCalendar.MONTH),
                        rango.getStart().get(GregorianCalendar.DAY_OF_MONTH),
                        diaConsultado.getHoraInicioAlmuerzo(),
                        diaConsultado.getMinutoinicioAlmuerzo()
                ),
                new GregorianCalendar(
                        rango.getStart().get(GregorianCalendar.YEAR),
                        rango.getStart().get(GregorianCalendar.MONTH),
                        rango.getStart().get(GregorianCalendar.DAY_OF_MONTH),
                        diaConsultado.getHoraFinAlmuerzo(),
                        diaConsultado.getMinutoFinAlmuerzo()
                )
        );

        if (horarioAlmuerzo.compareTo(rango) >= -2 && horarioAlmuerzo.compareTo(rango) <= 2) {
            return false;
        }

        for (Cita cita : citasDelDia) {
            if (cita.getRangoFecha().compareTo(rango) >= -2 && cita.getRangoFecha().compareTo(rango) <= 2) {
                return false;
            }
        }

        // En caso de que aun no hay comenzado a trabajar regresar false o en caso de que ya haya terminado de trabajar regresar false
        DateRange horarioTrabajo = new DateRange(
                new GregorianCalendar(
                        rango.getStart().get(GregorianCalendar.YEAR),
                        rango.getStart().get(GregorianCalendar.MONTH),
                        rango.getStart().get(GregorianCalendar.DAY_OF_MONTH),
                        diaConsultado.getHoraInicioTrabajo(),
                        diaConsultado.getMinutoInicioTrabajo()
                ),
                new GregorianCalendar(
                        rango.getStart().get(GregorianCalendar.YEAR),
                        rango.getStart().get(GregorianCalendar.MONTH),
                        rango.getStart().get(GregorianCalendar.DAY_OF_MONTH),
                        diaConsultado.getHoraFinTrabajo(),
                        diaConsultado.getMinutoFinTrabajo()
                )
        );

        return horarioTrabajo.compareTo(rango) > -2 && horarioTrabajo.compareTo(rango) < 2;
    }
    public boolean agregarCita(Cita cita) {
        return this.getCitasDelDia(cita.getRangoFecha().getStart().get(GregorianCalendar.DAY_OF_WEEK)).add(cita);
    }

    public void setTodasLasCitasInJList(JTextArea textArea) {
        int lengthCitas = 0;

        for (int i = GregorianCalendar.SUNDAY; i <= GregorianCalendar.SATURDAY; i++) {
            lengthCitas += this.getCitasDelDia(i).size();
        }

        StringBuilder citas = new StringBuilder();
        citas.append("Todas las citas");
        citas.append("\n\n");

        for (int i = GregorianCalendar.SUNDAY; i <= GregorianCalendar.SATURDAY; i++) {
            for (Cita cita : this.getCitasDelDia(i)) {
                citas.append(cita.toString()).append("\n");
            }
        }
        textArea.setText(citas.toString());
    }
}
