package com.joda.time;

import de.jollyday.Holiday;

import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import net.objectlab.kit.datecalc.common.DefaultHolidayCalendar;


public class JodaTime {

    public static void main(String[] args) {


        HolidayManager m = HolidayManager.getInstance();

        //Feriados de São Paulo, Brasil.
        Set<Holiday> feriados = m.getHolidays(2016, "br", "s");

        Set<LocalDate> dataDosFeriados = new HashSet<>();
        
    

        for (Holiday h : feriados) {
            LocalDate date = h.getDate();
            System.out.println(date);
            dataDosFeriados.add(date);
        }

        // popula com os feriados brasileiros
//        DefaultHolidayCalendar defaultHolidayCalendar = new DefaultHolidayCalendar(dataDosFeriados);
    }

//    public static void main(String[] args) {
//        LocalDate date = LocalDate.of(2016, Month.MARCH, 15);
//        Period p = Period.ofDays(5);
//    }
}
