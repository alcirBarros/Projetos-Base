package com.joda.time;

import de.jollyday.Holiday;
import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import org.joda.time.DateTime;
import org.joda.time.Period;

public class JodaTime_ {

    public static void main(String[] args) {
        try {
            //Data de inicio para teste
            Calendar cal = Calendar.getInstance();
            cal.set(2016, 3, 22, 22, 00, 00);
            System.out.println("Quantidade de horas trabalhadas [" + quantidadeHorasTrabalhadas(cal.getTime()) + "]");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static int quantidadeHorasTrabalhadas(Date dataInicio) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //Pega a quantidade de dias que passaram, com base na data inicio e fim
        long numeroDiasExecutados = (long) (new Date().getTime() - sdf.parse(new DateTime(dataInicio).getYear() + "-" + new DateTime(dataInicio).getMonthOfYear() + "-" + new DateTime(dataInicio).getDayOfMonth()).getTime()) / 86400000L;
        int totalHorasTrabalhadas = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataInicio);
        //Se a difenreça de data for igual a 0, é porque a data é a mesma da atual
        if (numeroDiasExecutados == 0) {
            return new Period(new DateTime(cal.getTime()), new DateTime()).toStandardHours().getHours();
            //Caso contrário, será adicionado +1, para poder contabilizar a data atual
        } else {
            numeroDiasExecutados += 1;
        }

        HolidayManager m = HolidayManager.getInstance(HolidayCalendar.BRAZIL);
        Set<Holiday> holidays = m.getHolidays(new DateTime(cal.getTime()).getYear());

        //Lista todos os dias, para poder fazer o calculo        
        for (int i = 1; i <= numeroDiasExecutados; i++) {
            //Verifica se é diferente de final de semana
            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                //Lista todos os feriados do brasil e em são paulo usando a api jollyday

                //Seta o ano conforme a data verificada, para poder listar os feriados
                boolean feriado = false;
                //Verifica se o dia atual é um dia de feriado
                for (Holiday h : holidays) {

                    //Date dataFeriado = sdf.parse(new DateTime(h.getDate().toDateTimeAtCurr)).getYear() + "- "+new DateTime(h.getDate().toDateTimeAtCurrentTime()).getMonthOfYear() + "- "+new DateTime(h.getDate().toDateTimeAtCurrentTime()).getDayOfMonth());
                    Date dataFeriado = sdf.parse(new DateTime(h.getDate().toEpochDay()).getYear() + "-" + new DateTime(cal.getTime()).getMonthOfYear() + "-" + new DateTime(cal.getTime()).getDayOfMonth());
                    
//                    int year = new DateTime(cal.getTime()).getYear();
//                    int monthOfYear = new DateTime(cal.getTime()).getMonthOfYear();
//                    int dayOfMonth = new DateTime(cal.getTime()).getDayOfMonth();
//                    Date dataFeriado = sdf.parse(year+"- "+monthOfYear+"- "+dayOfMonth);
                    Date dataAtual = sdf.parse(new DateTime(cal.getTime()).getYear()+"-"+new DateTime(cal.getTime()).getMonthOfYear()+"-"+new DateTime(cal.getTime()).getDayOfMonth());
                    if (dataFeriado.compareTo(dataAtual) == 0) {
                        feriado = true;
                        break;
                    }
                }
                //Verifica se é diferente de feriado para poder considerar um dia util e adicionar a quantidade de horas nesse dia
                if (!feriado) {
                    //Verifica se é o último dia
                    if (i == numeroDiasExecutados) {
                        //Seta o horario inicial dessa data, para poder calcular o horário
                        Calendar calInicial = Calendar.getInstance();
                        calInicial.set(new DateTime(cal.getTime()).getYear(), new DateTime(cal.getTime()).getMonthOfYear() - 1, new DateTime(cal.getTime()).getDayOfMonth(), 9, 0, 0);
                        totalHorasTrabalhadas += new Period(new DateTime(calInicial.getTime()), new DateTime()).toStandardHours().getHours();
                        //Verifica se ocorreu um almoço nesse dia, para poder retirar uma hora
                        if (new DateTime().getHourOfDay() == 14) {
                            totalHorasTrabalhadas -= 1;
                        }
                        //Verifica se é o primeiro dia
                    } else if (i == 1) {
                        //Seta o horario final dessa data, para poder calcular o horário
                        Calendar calFinal = Calendar.getInstance();
                        calFinal.set(new DateTime(cal.getTime()).getYear(), new DateTime(cal.getTime()).getMonthOfYear() - 1, new DateTime(cal.getTime()).getDayOfMonth(), 18, 0, 0);
                        totalHorasTrabalhadas += new Period(new DateTime(cal.getTime()), new DateTime(calFinal.getTime())).toStandardHours().getHours();
                        //Verifica se ocorreu um almoço nesse dia, para poder retirar uma hora
                        if (new DateTime(cal.getTime()).getHourOfDay() == 14) {
                            totalHorasTrabalhadas -= 1;
                        }
                        //Outros dias, 8 horas padrao retirando a hora de almoço
                    } else {
                        totalHorasTrabalhadas += 8;
                    }
                    //É um feriado
                } else if (feriado) {
                    System.out.println(" -- -- -- -- --Data de feriado----------");
                    System.out.println(cal.getTime());
                    System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --- ");
                }
            }
            //Acrescenta mais um dia na data para poder verificar se é dia util
            cal.add(Calendar.DATE, 1);
        }
        return totalHorasTrabalhadas;
    }
}
