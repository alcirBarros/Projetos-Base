package com.rsaraiva.labs.exapp02.rest;

import com.rsaraiva.labs.exapp02.model.Evento;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/eventos")
public class EventoResource {

    static final private Map<Integer, Evento> eventosMap;

    static {
        eventosMap = new HashMap<Integer, Evento>();
        
        Evento b1 = new Evento(1, "Java One 2013", new Date());
        eventosMap.put(b1.getId(), b1);
        
        Evento b2 = new Evento(2, "TDC", new Date());
        eventosMap.put(b2.getId(), b2);
    }

    @GET
    @Produces("text/xml")
    public List<Evento> getEventos() {
        return new ArrayList<Evento>(eventosMap.values());
    }

    @Path("{id}")
    @GET
    @Produces("text/xml")
    public Evento getEvento(@PathParam("id") int id) {
        return eventosMap.get(id);
    }

    @POST
    @Consumes("text/xml")
    @Produces("text/plain")
    public String adicionaEvento(Evento evento) {
        evento.setId(eventosMap.size() + 1);
        eventosMap.put(evento.getId(), evento);
        return evento.getNome() + " adicionado.\n";
    }

    @Path("{id}")
    @PUT
    @Consumes("text/xml")
    @Produces("text/plain")
    public String atualizaEvento(Evento evento, @PathParam("id") int id) {
        Evento atual = eventosMap.get(id);
        atual.setNome(evento.getNome());
        atual.setInicio(evento.getInicio());
        return evento.getNome() + " atualizada.\n";
    }

    @Path("{id}")
    @DELETE
    @Produces("text/plain")
    public String removeEvento(@PathParam("id") int id) {
        eventosMap.remove(id);
        return "Evento removido.\n";
    }
}
