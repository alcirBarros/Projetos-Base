package com.list.stream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * http://howtodoinjava.com/java-8/how-to-use-predicate-in-java-8/
 * http://www.mkyong.com/java8/java-8-streams-filter-examples/
 * http://www.dreamsyssoft.com/java-8-lambda-tutorial/filter-tutorial.php/
 * http://www.leveluplunch.com/java/examples/remove-filter-null-references-from-collection-list/
 */
public class FilterLambda {

    public static void main(String[] args) {
        converterEntidadeArrayToIntegerArray();
    }

    public static void converterEntidadeArrayToIntegerArray() {

        Entidade[] pessoaArry = {null, new Pessoa(null, "Pedro", 31, Sexo.FEMALE), new Pessoa(131, "Pedro", 31, Sexo.FEMALE), new Pessoa(234, "Anita", 44, Sexo.MALE)};
//      Entidade[] pessoaArry = {new Pessoa(23, "Pedro", 31, Sexo.FEMALE), new Pessoa(131, "Pedro", 31, Sexo.FEMALE), new Pessoa(234, "Anita", 44, Sexo.MALE)};
//      Entidade[] pessoaArry = null;

        Integer[] orElse = Optional.ofNullable(pessoaArry).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(Objects::nonNull).filter(y -> y.getId() != null).map(x -> x.getId()).toArray(Integer[]::new))).orElse(new Integer[]{});

        System.out.println(orElse);
    }

    public static void converterEntidadeListToIntegerArray() {
        Entidade[] pessoaArry = {null, new Pessoa(null, "Pedro", 31, Sexo.FEMALE), new Pessoa(131, "Pedro", 31, Sexo.FEMALE), new Pessoa(234, "Anita", 44, Sexo.MALE)};
        List<Entidade> asList = Arrays.asList(pessoaArry);
        Integer[] toArray = Optional.ofNullable(asList).orElseGet(Collections::emptyList).stream().filter(Objects::nonNull).filter(x -> x.getId() != null).map(x -> x.getId()).toArray(Integer[]::new);
        System.out.println(toArray);
    }

    public static void listTest(String[] args) {
        //        List<Pessoa> pessoaList = null;
//        pessoaList = new ArrayList<>();
//        pessoaList.add(null);
//        pessoaList.add(new Pessoa(221, "Julia", 19, Sexo.MALE));
//        pessoaList.add(new Pessoa(131, "Pedro", 31, Sexo.FEMALE));
//        pessoaList.add(new Pessoa(234, "Anita", 44, Sexo.MALE));

//        List<Pessoa> collect = Optional.ofNullable(pessoaList).orElseGet(Collections::emptyList).stream().filter(Objects::nonNull).collect(Collectors.toList());
//        System.out.println(collect);
//        List<Pessoa> olderUsers = pessoaList.stream().filter(Pessoa.isAdultMale()).collect(Collectors.toList());
//        System.out.println(olderUsers);
//
//        Pessoa pessoa = pessoaList.stream().filter(x -> 121 == x.getId()).findAny().orElse(null);
//        System.out.println(pessoa);
//
//        List<Pessoa> pessoas = pessoaList.stream().filter(like("Adri").and(like("Adriana"))).collect(Collectors.toList());
//        System.out.println(pessoas);
//        
//       sorted(pessoaList);
//        String[] arrayStringIsNull1 = arrayStringIsNull(null);
//        String[] arrayStringIsNull2 = arrayStringIsNull(new String[]{"", null});
//        String[] arrayStringIsNull3 = arrayStringIsNull(new String[]{null, ""});
//        String[] arrayStringIsNull4 = arrayStringIsNull(new String[]{""});
//        String[] arrayStringIsNull5 = arrayStringIsNull(new String[]{null, null});
//        String[] arrayStringIsNull6 = arrayStringIsNull(new String[]{"", ""});
//        String[] arrayStringIsNull7 = arrayStringIsNull(new String[]{"", "1111"});
//        String[] arrayStringIsNull8 = arrayStringIsNull(new String[]{"4424", "1111"});
//        String[] arrayStringIsNull9 = arrayStringIsNull(new String[]{"gfdg", null});
    }

    public static String[] arrayStringIsNull(String[] stringArray) {
        return Optional.ofNullable(stringArray).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(p -> p != null && !p.trim().isEmpty()).toArray(String[]::new))).orElse(null);
    }

    public static void sorted(List<Pessoa> pessoaList) {
        List<Pessoa> pessoas = Optional.ofNullable(pessoaList).orElseGet(Collections::emptyList).stream().sorted((x, y) -> x.getNome().compareTo(y.getNome())).filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(pessoas);
    }

    public static void map() {
        String intStreamToString = IntStream.of(1, 2, 3, 4).boxed().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(intStreamToString); // [1,2,3,4]
    }

    public static void map(List<Pessoa> pessoaList) {
        String s = pessoaList.stream().map(x -> "'" + x + "'").collect(Collectors.joining(", "));

        List<String> collect = pessoaList.stream().map(x -> new String(x.getNome())).collect(Collectors.toList());
        System.out.println(collect);
        //convert stream to String
//                .forEach(System.out::println);
    }

    public static Predicate<Pessoa> like(String string) {
        return x -> {
            //x.getNome().startsWith(string); // like "dig%"
            //x.getNome().endsWith(string); // like "%tal"
            //x.getNome().contains(string); // like "%gita%"
            if (x.getNome().startsWith(string)) {
                return true;
            }
            return false;
        };
    }

    public static List<Pessoa> filterEmployees(List<Pessoa> employees, Predicate<Pessoa> predicate) {
        return employees.stream().filter(predicate).collect(Collectors.<Pessoa>toList());
    }

}
