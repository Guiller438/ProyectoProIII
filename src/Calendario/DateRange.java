package Calendario;

import java.util.GregorianCalendar;

public class DateRange implements Comparable<DateRange>{
    private  GregorianCalendar start;
    private  GregorianCalendar end;


    public GregorianCalendar getStart() {
        return start;
    }

    public GregorianCalendar getEnd() {
        return end;
    }

    public DateRange(GregorianCalendar start, GregorianCalendar end) {
        this.start = start;
        this.end = end;
    }

    public DateRange(GregorianCalendar start, int horas, int minutos){
        this.start = start;
        this.end = (GregorianCalendar) start.clone();
        this.end.add(GregorianCalendar.HOUR_OF_DAY, horas);
        this.end.add(GregorianCalendar.MINUTE, minutos);
    }

    public boolean contains(DateRange dateRange) {
        return this.start.compareTo(dateRange.start) <= 0 && this.end.compareTo(dateRange.end) >= 0;
    }

    public boolean equals(DateRange dateRange) {
        return start.equals(dateRange.start) && end.equals(dateRange.end);
    }

    @Override
    public int compareTo(DateRange dateRange) {
        /*  Devuelve -3 en caso de que: 1122
                * El inicio del rango 1 sea menor que el inicio del rango 2 🗸
                * El fin del rango 1 sea menor que el inicio del rango 2 🗸

            Devuelve -2 en caso de que: 1212
                * El inicio del rango 1 sea menor que el inicio del rango 2 🗸
                * El fin del rango 1 sea mayor que el inicio del rango 2 🗸
                * El fin del rango 1 sea menor que el fin del rango 2 🗸

            Devuelve -1 en caso de que: 1221
                * El inicio del rango 1 sea menor que el inicio del rango 2 🗸
                * El fin del rango 1 sea mayor que el fin del rango 2 🗸

            Devuelve 0 en caso de que: (21)(21)
                * El inicio del rango 1 sea igual que el inicio del rango 2 🗸
                * El fin del rango 1 sea igual que el fin del rango 2 🗸

            Devuelve 1 en caso de que: 2112
                * El inicio del rango 1 sea mayor que el inicio del rango 2 🗸
                * El fin del rango 1 sea menor que el fin del rango 2 🗸

            Devuelve 2 en caso de que: 2121
                * El inicio del rango 1 sea mayor que el inicio del rango 2 🗸
                * El fin del rango 1 sea mayor que el fin del rango 2 🗸
                * El inicio del rango 1 sea menor que el fin del rango 2 🗸

            Devuelve 3 en caso de que: 2211
                * El inicio del rango 1 sea mayor que el fin del rango 2 🗸
                * El fin del rango 1 sea mayor que el fin del rango 2 🗸
        */

        if (this.start.compareTo(dateRange.start) < 0 && this.end.compareTo(dateRange.start) < 0) {
            return -3;
        } else if (this.start.compareTo(dateRange.start) < 0 && this.end.compareTo(dateRange.start) >= 0 && this.end.compareTo(dateRange.end) < 0) {
            return -2;
        } else if (this.start.compareTo(dateRange.start) <= 0 && this.end.compareTo(dateRange.end) > 0) {
            return -1;
        } else if (this.start.compareTo(dateRange.start) == 0 && this.end.compareTo(dateRange.end) == 0) {
            return 0;
        } else if (this.start.compareTo(dateRange.start) > 0 && this.end.compareTo(dateRange.end) <= 0) {
            return 1;
        } else if (this.start.compareTo(dateRange.start) > 0 && this.end.compareTo(dateRange.end) >= 0 && this.start.compareTo(dateRange.end) < 0) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
