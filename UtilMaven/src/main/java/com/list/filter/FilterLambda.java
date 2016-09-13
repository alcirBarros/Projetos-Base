package com.list.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * http://howtodoinjava.com/java-8/how-to-use-predicate-in-java-8/ http://www.mkyong.com/java8/java-8-streams-filter-examples/
 * http://www.dreamsyssoft.com/java-8-lambda-tutorial/filter-tutorial.php/
 * http://www.leveluplunch.com/java/examples/remove-filter-null-references-from-collection-list/
 */
public class FilterLambda {

    public static void main(String[] args) {
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(new Pessoa(121, "Adriana", 12, Sexo.MALE));
        pessoaList.add(new Pessoa(221, "Julia", 19, Sexo.MALE));
        pessoaList.add(new Pessoa(131, "Pedro", 31, Sexo.FEMALE));
        pessoaList.add(new Pessoa(234, "Anita", 44, Sexo.MALE));
        
//        List<Pessoa> olderUsers = pessoaList.stream().filter(Pessoa.isAdultMale()).collect(Collectors.toList());
//        System.out.println(olderUsers);
//
//        Pessoa pessoa = pessoaList.stream().filter(x -> 121 == x.getId()).findAny().orElse(null);
//        System.out.println(pessoa);
//
//        List<Pessoa> pessoas = pessoaList.stream().filter(like("Adri").and(like("Adriana"))).collect(Collectors.toList());
//        System.out.println(pessoas);

        sorted(pessoaList);
    }
    
    public static void sorted(List<Pessoa> pessoaList) {
        List<Pessoa> pessoas = pessoaList.stream().sorted((x, y) -> x.getNome().compareTo(y.getNome())).collect(Collectors.toList());
        System.out.println(pessoaList);
    }

    public static void map() {
        String intStreamToString = IntStream.of(1, 2, 3, 4).boxed().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(intStreamToString); // [1,2,3,4]
    }

    public static void map(List<Pessoa> pessoaList) {
        String s = pessoaList.stream().map(x -> "'" + x + "'").collect(Collectors.joining(", "));
        
        List<String> collect = pessoaList.stream() .map(x -> new String(x.getNome())).collect(Collectors.toList());
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
