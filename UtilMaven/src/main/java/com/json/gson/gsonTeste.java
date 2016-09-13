package com.json.gson;

import com.google.gson.Gson;
import java.io.Serializable;

public class gsonTeste {

    public static void main(String[] args) {
        MyBean bean = new MyBean();
        bean.data = "some data";
        bean.problem = new RuntimeException("Ack!");

        System.out.println(new Gson().toJson(bean));
    }
}

class MyBean implements Serializable{

    private static final long serialVersionUID = -6772417175279039904L;
    public String data;
    public Exception problem;
}

//public class gsonTeste {
//    public static void main(String[] args) {
//        String stringJson = "{'concurso': { 'numero':1499, 'dataSorteio':'01/06/2013', 'dezenas':[8,22,26,33,37,54] } }";
//
//        Gson gson = new Gson();
//
//        Resposta res = gson.fromJson(stringJson, Resposta.class);
//
//        Concurso concurso = res.concurso;
//        
//        System.err.println(concurso);
//
//    }
//}
//
//class Resposta{
//
//    Concurso concurso;
//}
//
//class Concurso{
//
//
//    private int numero;
//    private String dataSorteio;
//    private int[] dezenas;
//
//    public Concurso() {
//    }
//
//    @Override
//    public String toString() {
//
//        return numero + " - " + dataSorteio;
//    }
//
//}
