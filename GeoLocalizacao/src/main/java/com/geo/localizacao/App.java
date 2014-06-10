package com.geo.localizacao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App {

    HashMap<String, Object> objaa = new HashMap<String, Object>();

    public static void main(String[] args) {
//        DistanceMatrixResponse distanceMatrixResponse = new DistanceMatrixResponse();
        DistanceMatrixResponse calcularDistanciaXML = new App().calcularDistanciaXML("-23.1895584, -45.87689719999999", "-23.1896584, -45.87689719999999");

        System.out.println(calcularDistanciaXML);
    }

    public DistanceMatrixResponse calcularDistanciaXML(String origins, String destinations) {
        try {

            StringBuilder stringUrl = new StringBuilder("http://maps.googleapis.com/maps/api/distancematrix/xml?origins=");
            stringUrl.append(URLEncoder.encode(origins, "UTF-8"));
            stringUrl.append("&destinations=");
            stringUrl.append(URLEncoder.encode(destinations, "UTF-8"));
            stringUrl.append("&mode=driving&language=pt-BR&sensor=false");

            URL url = new URL(stringUrl.toString());

            InputStreamReader inputReader = new InputStreamReader(url.openStream());
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            String linha;
            String xml = "";
            while ((linha = bufferedReader.readLine()) != null) {
                xml += linha;
            }

            XStream stream = new XStream(new DomDriver());
            stream.alias("DistanceMatrixResponse", DistanceMatrixResponse.class);
            stream.alias("row", Row.class);
            stream.alias("element", Element.class);
            stream.alias("duration", Duration.class);
            stream.alias("distance", Distance.class);
            DistanceMatrixResponse distanceMatrixResponse = (DistanceMatrixResponse) stream.fromXML(xml.toString());

            return distanceMatrixResponse;

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}


