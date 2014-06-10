package com.goe.latlong;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.LatLng;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LatLong {

    public static void main(String args[]) {
        List<LatLng> geocoder = geocoder("RUA CASTRO ALVES", "33", "JARDIM PAULISTA", "SÃO JOSÉ DOS CAMPOS", "SÃO PAULO", "BRASIL");
        System.out.println(geocoder);
    }

    private static List<LatLng> geocoder(String rua, String numero, String bairro, String cidade, String estado, String pais) {
        StringBuilder enderecoBulder = new StringBuilder();

        enderecoBulder.append(rua).append(", "); //RUA
        enderecoBulder.append(numero).append(", "); //Número
        //endereco.append(bairro).append(", ");//Bairro
        enderecoBulder.append(cidade).append(" - "); // Cidade
        enderecoBulder.append(estado).append(", "); //Estado
        enderecoBulder.append(pais); //Pais

        // carregar coordenadas do google maps
        String toLowerCase = enderecoBulder.toString().toLowerCase();
        List<LatLng> latLngList = consultaGeoCodeLatLng(toLowerCase);
        return latLngList;
    }

    private static List<LatLng> consultaGeoCodeLatLng(String s) {
        final Geocoder geocoder = new Geocoder();
        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(s).setLanguage("pt").getGeocoderRequest();
        GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);

        List<LatLng> latLngList = new ArrayList<LatLng>();

        if (geocoderResponse != null) {
            BigDecimal lat = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLat();
            BigDecimal lng = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLng();
            latLngList.add(new LatLng(lat, lng));
        }
        return latLngList;
    }
}
