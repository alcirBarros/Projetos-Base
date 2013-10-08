package com.mapa.evento;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

public class PostCoordenadasGps {

//    public static void main(String[] args) {
//        try {
//            Client client = Client.create();
//            WebResource webResource = client.resource("http://localhost:8080/GpsMapa/webservice/eventos/post");
//
//            CoordenadasGps coordenadasGps = new CoordenadasGps();
//            coordenadasGps.setLatitude(4.381542);
//            coordenadasGps.setLongetude(4.351542);
//            ClientResponse response = webResource.type(MediaType.APPLICATION_XML).post(ClientResponse.class, coordenadasGps);
//
////            if (response.getStatus() != 201) {
////                throw new RuntimeException("Failed : HTTP error code : "
////                + response.getStatus());
////            }
//
//            System.out.println("Output from Server .... \n");
//            String output = response.getEntity(String.class);
//            System.out.println(output);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/GpsMapa/webservice/eventos");

            ClientResponse response = webResource.accept("text/xml").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}