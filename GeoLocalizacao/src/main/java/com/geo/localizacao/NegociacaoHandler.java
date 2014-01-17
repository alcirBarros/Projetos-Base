/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geo.localizacao;

import java.util.jar.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author alci
 */
public class NegociacaoHandler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {

    }

    public void startElement(String uri, String localName,
            String name, Attributes attributes) throws SAXException {
        // aqui voce é avisado, por exemplo
        // do inicio da tag "<preco>"
    }

    @Override
    public void characters(char[] chars, int offset, int len)
            throws SAXException {
    // aqui voce seria avisado do inicio
        // do conteudo que fica entre as tags, como por exemplo 30
        // de dentro de "<preco>30</preco>"

        // para saber o que fazer com esses dados, voce precisa antes ter
        // guardado em algum atributo qual era a negociação que estava
        // sendo percorrida
    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        // aviso de fechamento de tag
    }
}
