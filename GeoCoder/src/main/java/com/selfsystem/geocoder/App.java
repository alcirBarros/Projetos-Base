package com.selfsystem.geocoder;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlElement;

public class App {

    public static void main(String[] args) {
        teste();
    }

    public static void teste() {
        try {
            URL url = new URL("http://maps.googleapis.com/maps/api/distancematrix/xml?origins=Porto Alegre&destinations=Sao Paulo&mode=driving&language=pt-BR&sensor=false");
            
            InputStreamReader inputReader = new InputStreamReader(url.openStream());
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            String linha = "";
            String xml = "";

            while ((linha = bufferedReader.readLine()) != null) {
                xml += linha;
            }

            
            
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
