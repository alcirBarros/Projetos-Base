/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author alcir
 */
public class Cliente {

    public static void main(String[] args) {

        //Declaro o socket cliente  
        Socket socket = null;

        //Declaro a Stream de saida de dados  
        PrintStream ps = null;

        try {

            //Cria o socket com o recurso desejado na porta especificada  
            socket = new Socket("127.0.0.1", 7000);

            //Cria a Stream de saida de dados  
            ps = new PrintStream(socket.getOutputStream());

            Scanner scanner = new Scanner(socket.getInputStream());

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            //Imprime uma linha para a stream de saída de dados  
            ps.println("Estou enviando dados para o servidor");

            //Trata possíveis exceções  
        } catch (IOException e) {

            System.out.println("Algum problema ocorreu ao criar ou enviar dados pelo socket.");

        } finally {

            try {

                //Encerra o socket cliente  
                socket.close();

            } catch (IOException e) {
            }

        }

    }
}
