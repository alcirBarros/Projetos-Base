//package com.calendar;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import org.joda.time.DateTime;
//import org.joda.time.Days;
//
//public class CalendarTest {
//
//    public static final SimpleDateFormat DD_MM_YYYYY_hh_mm_ss = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//
//    public static Calendar getPrimeiroDataHoraMes(Date data) {
//        Calendar dataHora = Calendar.getInstance();
//        dataHora.setTime(data);
//        dataHora.set(Calendar.DAY_OF_MONTH, 1);
//        dataHora.set(Calendar.HOUR_OF_DAY, 0);
//        dataHora.set(Calendar.MINUTE, 0);
//        dataHora.set(Calendar.SECOND, 0);
//        return dataHora;
//    }
//
//    public static Calendar getUtimaDataHoraMes(Date data) {
//        Calendar dataHora = Calendar.getInstance();
//        dataHora.setTime(data);
//        dataHora.set(Calendar.DAY_OF_MONTH, dataHora.getActualMaximum(Calendar.DAY_OF_MONTH));
//        dataHora.set(Calendar.HOUR_OF_DAY, 23);
//        dataHora.set(Calendar.MINUTE, 59);
//        dataHora.set(Calendar.SECOND, 59);
//        return dataHora;
//    }
//
//    public static Date[] getPrimeiraEUltimaDataHoraDoMes(Date data) {
//        Calendar dataInicial = getPrimeiroDataHoraMes(data);
//        Calendar dataFinal = getUtimaDataHoraMes(data);
//        Date datas[] = new Date[2];
//        datas[0] = dataInicial.getTime();
//        datas[1] = dataFinal.getTime();
//        return datas;
//    }
//
//    public static int numeroDeDiasEntreDuasDatas(Calendar dataHoraInicio, Calendar dataHoraFim) {
//        return numeroDeDiasEntreDuasDatas(dataHoraInicio.getTime(), dataHoraFim.getTime());
//    }
//
//    public static int numeroDeDiasEntreDuasDatas(Date dataHoraInicio, Date dataHoraFim) {
//        DateTime dataInicial = new DateTime(dataHoraInicio);
//        DateTime dataFinal = new DateTime(dataHoraFim);
//        int dias = Days.daysBetween(dataInicial, dataFinal).getDays();
//        return dias;
//    }
//
//    public static long getIntervalo(java.util.Date inicio, java.util.Date fim) {
//        if (fim.compareTo(inicio) < 0) {
//            throw new RuntimeException("Data fim menor que data inicio");
//        }
//        return (fim.getTime() - inicio.getTime());
//    }
//
//    public static int getIntervaloDia(java.util.Date inicio, java.util.Date fim) {
//        long intervalo = getIntervalo(inicio, fim);
//        return (int) (intervalo / (24 * 3600 * 1000));
//    }
//
//    public static void main(String[] args) throws ParseException {
////        Date[] date = getPrimeiraEUltimaDataHoraDoMes(new Date());
////        System.out.println(date[0]);
////        System.out.println(date[1]);
//
////        Date dataHoraInicio = CalendarTest.DD_MM_YYYYY_hh_mm_ss.parse("01/06/2016 00:00:00");
////        Date dataHoraFim = CalendarTest.DD_MM_YYYYY_hh_mm_ss.parse("01/07/2016 00:00:00");
////        int numeroDeDiasEntreDuasDatas = numeroDeDiasEntreDuasDatas(dataHoraInicio, dataHoraFim);
////        System.out.println(numeroDeDiasEntreDuasDatas);
//
//
//        Date dataHoraInicio = CalendarTest.DD_MM_YYYYY_hh_mm_ss.parse("01/06/2016 00:00:00");
//        Date dataHoraFim = CalendarTest.DD_MM_YYYYY_hh_mm_ss.parse("30/06/2016 23:59:59");
//        int numeroDeDiasEntreDuasDatas = getIntervaloDia(dataHoraInicio, dataHoraFim);
//        System.out.println(numeroDeDiasEntreDuasDatas);
//    }
//
//}
