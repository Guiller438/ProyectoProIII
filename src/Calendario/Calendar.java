package Calendario;

import java.util.ArrayList;
import java.util.TreeSet;

public class Calendar {
    private ArrayList<TreeSet<DateRange>> calendar;

    public Calendar(){
        this.calendar = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            this.calendar.add(new TreeSet<>());
        }
    }
}
