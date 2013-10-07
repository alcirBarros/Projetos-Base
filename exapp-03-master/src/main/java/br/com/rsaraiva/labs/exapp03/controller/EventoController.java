package br.com.rsaraiva.labs.exapp03.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.rsaraiva.labs.exapp03.model.Evento;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import javax.ws.rs.core.MediaType;

@Resource
public class EventoController {
    
    private final String URL_REST = "http://localhost:8080/exapp-02/eventos";
    private WebResource service = Client.create().resource(URL_REST);

    private Result result;
    
    public EventoController(Result result) {
        this.result = result;
    }
    
    public List<Evento> lista() {
        return service.get(new GenericType<List<Evento>>(){});
    }
    
    public void salva(Evento evento) {
        ClientResponse response = service.type(MediaType.TEXT_XML).post(ClientResponse.class, evento.asXML());
        result.redirectTo(this).lista();
    }
    
    public void form() {}
}
