package Calendario;

public class Horario {
    private int horaInicioTrabajo;
    private int horaFinTrabajo;
    private int minutoInicioTrabajo;
    private int minutoFinTrabajo;
    private int horaInicioAlmuerzo;
    private int minutoinicioAlmuerzo;
    private int horaFinAlmuerzo;
    private int minutoFinAlmuerzo;

    public Horario(int horaInicioTrabajo, int minutoInicioTrabajo, int horaFinTrabajo, int minutoFinTrabajo, int horaInicioAlmuerzo, int minutoinicioAlmuerzo, int horaFinAlmuerzo, int minutoFinAlmuerzo){
        this.horaInicioTrabajo = horaInicioTrabajo;
        this.minutoInicioTrabajo = minutoInicioTrabajo;
        this.horaFinTrabajo = horaFinTrabajo;
        this.minutoFinTrabajo = minutoFinTrabajo;
        this.horaInicioAlmuerzo = horaInicioAlmuerzo;
        this.minutoinicioAlmuerzo = minutoinicioAlmuerzo;
        this.horaFinAlmuerzo = horaFinAlmuerzo;
        this.minutoFinAlmuerzo = minutoFinAlmuerzo;
    }

    public int getHoraInicioTrabajo() {
        return horaInicioTrabajo;
    }

    public int getHoraFinTrabajo() {
        return horaFinTrabajo;
    }

    public int getMinutoInicioTrabajo() {
        return minutoInicioTrabajo;
    }

    public int getMinutoFinTrabajo() {
        return minutoFinTrabajo;
    }

    public int getHoraInicioAlmuerzo() {
        return horaInicioAlmuerzo;
    }

    public int getMinutoinicioAlmuerzo() {
        return minutoinicioAlmuerzo;
    }

    public int getHoraFinAlmuerzo() {
        return horaFinAlmuerzo;
    }

    public int getMinutoFinAlmuerzo() {
        return minutoFinAlmuerzo;
    }

    public Horario(int[] horario) {
        this(horario[0], horario[1], horario[2], horario[3], horario[4], horario[5], horario[6], horario[7]);
    }
}
