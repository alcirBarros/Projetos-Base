package com.list.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class NewClass {

    public static void main(String[] args) {
        converterIntegerArrayToIntegerListIsNotNull();
    }

    public static void converterIntegerArrayToIntegerListIsNotNull() {
        Integer[] stringArray = {1, null, 3};

        List<Integer> orElseGet = Optional.ofNullable(stringArray).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(Objects::nonNull).collect(Collectors.toList()))).orElseGet(Collections::emptyList);

        System.out.println(orElseGet);
    }

    public static void converterToArrayId() {
        String[] stringArray = null;

        List<String> asList = Arrays.asList(stringArray);

        List<Pessoa> pessoaList = new ArrayList<Pessoa>();
        pessoaList.add(new Pessoa(null, "A", 12, Sexo.MALE));
        pessoaList.add(new Pessoa(null, "B", 15, Sexo.MALE));
        pessoaList.add(new Pessoa(4, "C", 31, Sexo.FEMALE));
        pessoaList.add(new Pessoa(6, "D", 44, Sexo.MALE));

        Integer[] toArray = Optional.ofNullable(pessoaList).orElseGet(Collections::emptyList).stream().map(x -> x.getId()).filter(Objects::nonNull).toArray(Integer[]::new);

        System.out.println(toArray);

    }

    public static void list(String[] args) {
        List<Integer> list = new ArrayList<>();
//        list.add(null);
//        list.add(null);
//        list.add(null);

        List<Integer> collect = Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().filter(Objects::nonNull).collect(Collectors.toList());

//        List<Integer> collect = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
//        
        System.out.println(collect);
    }

    public static void hasMap() {
        //saldoProdutoMovimentacaoList.stream().collect(Collectors.toMap(SaldoProdutoMovimentacao::getId, item -> item));
    }

    public static void array(String[] args) {
        String[] stringArray = {"", null, "11"};

        String[] orElse = Optional.ofNullable(stringArray).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(p -> p != null && !p.trim().equals("")).toArray(String[]::new))).orElse(new String[]{});

        System.out.println(orElse);

        //String[] toArray = Arrays.asList(stringArray).stream().filter(p -> p != null).toArray(size -> new String[size]);
        //String[] orElse = Optional.ofNullable(stringArray).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(p -> p != null).toArray(size -> new String[size]))).orElse(new String[]{});
        Optional<Object[]> get = Optional.ofNullable(stringArray).flatMap(o -> Optional.of(Arrays.asList(o).stream().filter(p -> p != null).toArray()));
        //if (get.isPresent()) {
        //    Arrays.asList(get).stream().forEach(System.out::println);
        //}
        System.out.println(get);
    }

    public static void groupBy(String[] args) {
// http://stackoverflow.com/questions/17081063/how-should-we-manage-jdk8-stream-for-null-values
//        
        List<Pessoa> pessoaList = new ArrayList<Pessoa>();
        pessoaList.add(new Pessoa(12, Sexo.MALE));
        pessoaList.add(new Pessoa(15, Sexo.MALE));
        pessoaList.add(new Pessoa(31, Sexo.FEMALE));
        pessoaList.add(new Pessoa(44, Sexo.MALE));

        Map<Sexo, List<Pessoa>> collect = pessoaList.stream().filter(p -> p != null).collect(Collectors.groupingBy(Pessoa::getSex));

        System.out.println(collect);
    }

}
