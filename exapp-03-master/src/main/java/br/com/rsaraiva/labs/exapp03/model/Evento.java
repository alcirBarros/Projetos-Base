package br.com.rsaraiva.labs.exapp03.model;

import br.com.rsaraiva.labs.exapp03.rest.DateAdapter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Evento {

    private Integer id;
    private String nome;
    private Date inicio;

    public Evento() {
    }

    public Evento(Integer id, String nome, Date inicio) {
        this.id = id;
        this.nome = nome;
        this.inicio = inicio;
    }
    
    public String asXML() {
        XStream xstream = new XStream();
        xstream.alias("eventoes", List.class);
        xstream.alias("evento", Evento.class);
        xstream.registerConverter(new DateConverter("dd/MM/yyyy", new String[]{}));
        return xstream.toXML(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
}
