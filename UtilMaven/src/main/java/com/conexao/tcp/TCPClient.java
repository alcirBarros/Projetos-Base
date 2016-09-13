package com.conexao.tcp;

import java.net.*;
import java.io.*;

public class TCPClient {

    public static void main(String args[]) {
        // arguments supply message and hostname
        Socket s = null;
        try {
            int serverPort = 7896;

            InetAddress aHost = InetAddress.getByName("localhost");

            s = new Socket(aHost, serverPort);

            DataInputStream recebe = new DataInputStream(s.getInputStream());
            DataOutputStream envia = new DataOutputStream(s.getOutputStream());

            envia.writeUTF("Palavra");      // UTF is a string
            // encoding see Sn. 4.4

            String data = recebe.readUTF();     // read a line of data
            System.out.println("Received: " + data);

            //from the stream
        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    System.out.println("close:" + e.getMessage());
                }
            }
        }
    }
}
