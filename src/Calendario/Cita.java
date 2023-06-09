package Calendario;

import Almacenamiento.ListaCitas;
import Almacenamiento.ListaClientes;
import Almacenamiento.ListaUsuarios;
import Personas.Cliente;
import Personas.Tecnico;

import java.util.GregorianCalendar;



public class Cita implements Comparable<Cita>{
    private static int nextId = 0;
    private int id;
    private DateRange rangoFecha;
    private Tecnico tecnico;
    private Cliente cliente;

    public int getId() {
        return id;
    }

    public DateRange getRangoFecha() {
        return rangoFecha;
    }

    public void setRangoFecha(DateRange rangoFecha) {
        this.rangoFecha = rangoFecha;
    }

    static {
        nextId = 0;
    }
    public Cita(DateRange rangoFecha, String cedulaTecnico, String cedulaCliente){
        this.id = nextId++;
        this.rangoFecha = rangoFecha;
        this.cliente = ListaClientes.search(cedulaCliente);
        this.tecnico = (Tecnico) ListaUsuarios.search(cedulaTecnico);
    }

    public Cita(GregorianCalendar fechaInicio, int duracionHora, int duracionMinuto, String cedulaCliente, String cedulaTecnico){
        this(new DateRange(fechaInicio,
                new GregorianCalendar(
                        fechaInicio.get(GregorianCalendar.YEAR),
                        fechaInicio.get(GregorianCalendar.MONTH),
                        fechaInicio.get(GregorianCalendar.DAY_OF_MONTH),
                        fechaInicio.get(GregorianCalendar.HOUR_OF_DAY) + duracionHora,
                        fechaInicio.get(GregorianCalendar.MINUTE) + duracionMinuto
                )),
                cedulaTecnico, cedulaCliente);
    }
    public Cita (int id){
        this.id = id;
    }
    public String getFechaInicio(){
        var fecha = this.rangoFecha.getStart();
        return fecha.get(GregorianCalendar.YEAR) + "/" +
                (fecha.get(GregorianCalendar.MONTH) + 1) + "/" +
                fecha.get(GregorianCalendar.DAY_OF_MONTH);
    }
    public String getHoraInicio() {
        var fecha = this.rangoFecha.getStart();

        return fecha.get(GregorianCalendar.HOUR_OF_DAY) + ":" +
                (fecha.get(GregorianCalendar.MINUTE) < 10 ? "0" : "") + fecha.get(GregorianCalendar.MINUTE);
    }
    public String getHoraFin() {
        var fecha = this.rangoFecha.getEnd();

        return fecha.get(GregorianCalendar.HOUR_OF_DAY) + ":" +
                (fecha.get(GregorianCalendar.MINUTE) < 10 ? "0" : "") + fecha.get(GregorianCalendar.MINUTE);
    }
    @Override
    public String toString() {
        return "Cita #" + this.id + " <> " + this.getFechaInicio() + " <> " + this.getHoraInicio() + " <> " + this.getHoraFin() + " <> " + this.cliente + " <> " + this.tecnico;
    }
    @Override
    public int compareTo(Cita cita) {
        return this.rangoFecha.compareTo(cita.rangoFecha);
    }
}
