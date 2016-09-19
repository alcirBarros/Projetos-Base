package com.selfsystem.geocoder;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

/**
 *
 * @author alci
 */
public class LeitorXML {

    public List<Distancia> carrega(Reader fonte) {
        XStream stream = new XStream(new DomDriver());
        stream.alias("distancia", Distancia.class);
        return (List<Distancia>) stream.fromXML(fonte);
    }

    public static void main(String args[]) {
        String xmlDeTeste = "<list> <negocio> <preco>43.5</preco>  <quantidade>1000</quantidade> <data> <time>1322233344455</time> </data> </negocio> </list>"; // o XML vai aqui!

        LeitorXML leitor = new LeitorXML();
        List<Distancia> negocios = leitor.carrega(new StringReader(xmlDeTeste));
    }
}
