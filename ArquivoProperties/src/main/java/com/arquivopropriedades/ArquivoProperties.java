package com.arquivopropriedades;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author alcir
 */
public class ArquivoProperties {



    public static void main(String args[]) throws IOException {
        
        criar();
        ler();
        
    }

    private static void criar() {
        //Cria um objeto da classe java.util.Properties
        Properties properties = new Properties();

        //setando as propriedades(key) e os seus valores(value)
        properties.setProperty("prop.server.login", "TESTE");
        properties.setProperty("prop.server.host", "TESTE");
        properties.setProperty("prop.server.password", "TESTE");

        try {
            //Criamos um objeto FileOutputStream            

            FileOutputStream file = new FileOutputStream("./properties/dados.properties");
            
            //grava os dados no arquivo
           // properties.storeToXML(file, "FILE JDBC PROPERTIES:");
            properties.store(file, "FILE JDBC PROPERTIES:");
            //fecha o arquivo
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void ler() throws IOException {
        String login; //Variavel que guardará o login do servidor. 
        String host;  //Variavel que guardará o host do servidor. 
        String password; //Variável que guardará o password do usúario. 

        System.out.println("************Teste de leitura do arquivo de propriedades************");
        
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("./properties/dados.properties");
       // props.loadFromXML(file);
        props.load(file);

        login = props.getProperty("prop.server.login");
        host = props.getProperty("prop.server.host");
        password = props.getProperty("prop.server.password");

        System.out.println("Login = " + login);
        System.out.println("Host = " + host);
        System.out.println("Password = " + password);
    }
}
