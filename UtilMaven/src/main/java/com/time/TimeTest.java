package com.time;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.joda.time.Weeks;

/*
https://rodrigouchoa.wordpress.com/2013/11/20/novidades-do-java-8-jsr-310-date-and-time-api/
http://blog.caelum.com.br/streams-e-datas-para-os-desafios-do-dia-a-dia-no-java-8/
 */
public class TimeTest {

    /**
     * Observe que utilizamos a classe Duration. Essa classe serve para medir uma quantidade de tempo em termos de nanossegundos. Você pode obter essa quantidade de tempo em
     * diversas unidades chamando métodos: toNanos, toMillis, getSeconds, etc.
     */
    private static Long tempoGasto() {
        Instant instantInicio = Instant.now();
        for (int i = 0; i < 10; i++) {
        }
        Instant instantFim = Instant.now();
        Duration duracao = Duration.between(instantInicio, instantFim);
        long duracaoEmMilissegundos = duracao.toNanos();
        return duracaoEmMilissegundos;
    }

    private static Instant dataHoraAtual() {
        Instant dataHoraAtual = Instant.now();
        return dataHoraAtual;
    }

//  LocalDate serve para representarmos, por exemplo , a data de emissão do nosso RG, em que não nos importa as horas ou minutos, mas o dia todo.
    private static LocalDate localDate() {
        LocalDate emissaoRG = LocalDate.of(2016, Month.JANUARY, 15);
        LocalDate hoje = LocalDate.now();
        return hoje;//2014-04-08 (formato ISO-8601)
    }

    private static void duracao() {
        LocalDate homemNoEspaco = LocalDate.of(1961, Month.APRIL, 12);
        LocalDate homemNaLua = LocalDate.of(1969, Month.MAY, 25);
        Period periodo = Period.between(homemNoEspaco, homemNaLua);
        System.out.printf("%s anos, %s mês e %s dias", periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }

//    Já a classe LocalTime serve para representar apenas um horário, sem data específica. 
//    Podemos, por exemplo, usá-la para representar um horário de entrada no trabalho.
    private static void hora() {
        LocalTime horarioDeEntrada = LocalTime.of(9, 0);
        System.out.println(horarioDeEntrada); //09:00
    }

    private static void dataHora() {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime aberturaDaCopa = LocalDateTime.of(2014, Month.JUNE, 12, 17, 0);
        System.out.println(aberturaDaCopa); //2014-06-12T17:00 (formato ISO-8601)

    }

    /**
     * Para representarmos uma data e hora em um fuso horário específico, devemos utilizar a classe ZonedDateTime. Se calcularmos de maneira ingênua a duração do voo, teríamos
     * 8:40. Porém, como há uma diferença entre os fusos horários de São Paulo e Nova York, a duração correta é 9:40. Repare que a API já faz o tratamento de fusos horários
     * distintos.
     */
    private static void dataComFusoHorario() {
        ZoneId fusoHorarioDeSaoPaulo = ZoneId.of("America/Sao_Paulo");
        ZoneId fusoHorarioDeNovaYork = ZoneId.of("America/New_York");

        ZonedDateTime agoraEmSaoPaulo = ZonedDateTime.now(fusoHorarioDeSaoPaulo);
        System.out.println(agoraEmSaoPaulo); //2014-04-08T10:02:57.838-03:00[America/Sao_Paulo]

        LocalDateTime saidaDeSaoPauloSemFusoHorario = LocalDateTime.of(2014, Month.APRIL, 4, 22, 30);
        LocalDateTime chegadaEmNovaYorkSemFusoHorario = LocalDateTime.of(2014, Month.APRIL, 5, 7, 10);

        ZonedDateTime saidaDeSaoPauloComFusoHorario = ZonedDateTime.of(saidaDeSaoPauloSemFusoHorario, fusoHorarioDeSaoPaulo);
        System.out.println(saidaDeSaoPauloComFusoHorario); //2014-04-04T22:30-03:00[America/Sao_Paulo]

        ZonedDateTime chegadaEmNovaYorkComFusoHorario = ZonedDateTime.of(chegadaEmNovaYorkSemFusoHorario, fusoHorarioDeNovaYork);
        System.out.println(chegadaEmNovaYorkComFusoHorario); //2014-04-05T07:10-04:00[America/New_York]

        Duration duracaoDoVoo = Duration.between(saidaDeSaoPauloComFusoHorario, chegadaEmNovaYorkComFusoHorario);
        System.out.println(duracaoDoVoo); //PT9H40M
    }

    /**
     * Um cuidado importante que devemos ter é em relação ao horário de verão. No fim do horário de verão, por exemplo, a mesma hora existe duas vezes!
     */
    private static void horarioDeVerao() {
        ZoneId fusoHorarioDeSaoPaulo = ZoneId.of("America/Sao_Paulo");

        LocalDateTime fimDoHorarioDeVerao2013SemFusoHorario = LocalDateTime.of(2014, Month.FEBRUARY, 15, 23, 00);

        ZonedDateTime fimDoHorarioVerao2013ComFusoHorario = fimDoHorarioDeVerao2013SemFusoHorario.atZone(fusoHorarioDeSaoPaulo);
        System.out.println(fimDoHorarioVerao2013ComFusoHorario); //2014-02-15T23:00-02:00[America/Sao_Paulo]

        ZonedDateTime maisUmaHora = fimDoHorarioVerao2013ComFusoHorario.plusHours(1);
        System.out.println(maisUmaHora); //2014-02-15T23:00-03:00[America/Sao_Paulo]
    }

    private static void dataMesImportante() {

        Year year = Year.of(2016);
        Month month = Month.JANUARY;
        MonthDay diaMes = MonthDay.of(Month.JANUARY, 29);
        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;

        YearMonth copaDoMundo2014 = YearMonth.of(2014, Month.JUNE);

    }

    private static void formatandoData() {

        //criação de um DateTimeFormatter com o padrao dd/MM/yyyy (dia/mes/ano)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        //criar um objeto LocalDatel a partir da String &quot;15/11/2013&quot;
        String s = "15/11/2013 12:11:12";
        LocalDateTime data = LocalDateTime.parse(s, formatter);
        System.out.println(data);

        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateTimeFormatter = hoje.format(formatador); //08/04/2014
        System.out.println(dateTimeFormatter);

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter_ = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt", "br"));
        String formatador_ = agora.format(dateTimeFormatter_); //08/04/14 10:02
        System.out.println(formatador_);
    }

    /*
    * Todas as classes mencionadas possuem diversos métodos que permitem manipular as medidas de tempo. 
    * Por exemplo, podemos usar o método plusDays da classe LocalDate para aumentarmos um dia:
     */
    private static void manipulandoData() {
        LocalDate hoje = LocalDate.now();
        LocalDate amanha = hoje.plusDays(1);
        System.out.println("Amanhã é: " + amanha);
    }

    /*
    * Medidas de tempo até uma determinada data, que podemos fazer através do método until. 
    * Para descobrir o número de dias até uma data, por exemplo, devemos passar ChronoUnit.DAYS como parâmetro.
     */
    private static void medidaDeTempo() {
        MonthDay natal = MonthDay.of(Month.DECEMBER, 25);
        LocalDate natalDesseAno = natal.atYear(Year.now().getValue());
        long diasAteONatal = LocalDate.now().until(natalDesseAno, ChronoUnit.DAYS);
        System.out.println(diasAteONatal);
    }

    private static void temporalAdjuste() {
        TemporalAdjuster ajustadorParaProximaSexta = TemporalAdjusters.next(DayOfWeek.FRIDAY);
        LocalDate proximaSexta = LocalDate.now().with(ajustadorParaProximaSexta);
        System.out.println("Proxima Sexta: " + proximaSexta);
    }

    private static void diasUteisNoAno() {
        int ano = 2016;
        int mes = 6;
        Year anoMes = Year.of(ano);

        List<LocalDate> listaDosDiasUteisDoMes = Stream.iterate(anoMes.atDay(1), data -> data.plusDays(1)).limit(anoMes.length()).filter(data -> !data.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !data.getDayOfWeek().equals(DayOfWeek.SUNDAY)).collect(Collectors.toList());

        System.out.println(listaDosDiasUteisDoMes);
    }

    private static void diasUteisNoMes() {
        int ano = 2016;
        int mes = 6;
        YearMonth anoMes = YearMonth.of(ano, mes);

        List<LocalDate> listaDosDiasUteisDoMes = Stream.iterate(anoMes.atDay(1), data -> data.plusDays(1)).limit(anoMes.lengthOfMonth()).filter(data -> !data.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !data.getDayOfWeek().equals(DayOfWeek.SUNDAY)).collect(Collectors.toList());

        System.out.println(listaDosDiasUteisDoMes);
    }

    private static void criarData() {

        DayOfWeek SEXTA_FEIRA = DayOfWeek.FRIDAY;
        DayOfWeek SEGUNDA_FEIRA = DayOfWeek.MONDAY;
        DayOfWeek SÁBADO = DayOfWeek.SATURDAY;
        DayOfWeek DOMINGO = DayOfWeek.SUNDAY;
        DayOfWeek AQUINTA_FEIRA = DayOfWeek.THURSDAY;
        DayOfWeek TERÇA_FEIRA = DayOfWeek.TUESDAY;
        DayOfWeek QUARTA_FEIRA = DayOfWeek.WEDNESDAY;

        Weeks weeks = Weeks.weeks(1);

        //criar datas
        LocalDate dataAtual = LocalDate.now(); //data atual
        LocalDate data1 = LocalDate.of(2014, 3, 22); //22-mar-2014
        LocalDate data2 = LocalDate.of(2014, Month.MARCH, 22); //22-mar-2014
        LocalDate data3 = Year.of(2010).atMonth(12).atDay(24); //24-dez-2010
        //criar objeto com data e hora
        LocalDateTime dateTimeAtual = LocalDateTime.now();
        LocalDateTime dateTime1 = LocalDateTime.of(2013, Month.MARCH, 21, 21, 10, 1); //21-mar-2013 as 21h10m1
    }

    private static void primeiroDiaDoAno() {
        LocalDate localDate = LocalDate.now(); //data atual
        LocalDate primeiroDiaDoAno = localDate.with(TemporalAdjusters.firstDayOfYear());
        System.out.println(primeiroDiaDoAno);
    }

    private static void utimoDiaDoAno() {
        LocalDate localDate = LocalDate.now(); //data atual
        LocalDate utimoDiaDoAno = localDate.with(TemporalAdjusters.lastDayOfYear());
        System.out.println(utimoDiaDoAno);
    }

    private static void primeriDiaDoMes() {
        LocalDate localDate = LocalDate.now(); //data atual
        LocalDate primeiroDiaDoMes = localDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(primeiroDiaDoMes);
    }

    private static void utimoDiaDoMes() {
        LocalDate localDate = LocalDate.now(); //data atual
        LocalDate utimoDiaDoMes = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(utimoDiaDoMes);
    }

    private static void primeiroDiaDoProximoMes() {
        LocalDate localDate = LocalDate.now(); //data atual
        LocalDate primeiroDiaDoMes = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(primeiroDiaDoMes);
    }

    public static void main(String[] args) {
        utimoDiaDoMes();
    }
}
