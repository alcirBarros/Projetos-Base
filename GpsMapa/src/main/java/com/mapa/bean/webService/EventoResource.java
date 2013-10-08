package com.mapa.bean.webService;

import com.mapa.evento.CoordenadasGps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/eventos")
public class EventoResource {

    private static final Map<Integer, CoordenadasGps> eventosMap;

    static {
        eventosMap = new HashMap<Integer, CoordenadasGps>();

        CoordenadasGps b1 = new CoordenadasGps();
        b1.setId(1);
        b1.setLatitude(41.381542);
        b1.setLongetude(2.122893);
        eventosMap.put(b1.getId(), b1);
//
//        CoordenadasGps b2 = new CoordenadasGps();
//        b2.setId(2);
//        b2.setLatitude(42.382522);
//        b2.setLongetude(2.122813);
//        eventosMap.put(b2.getId(), b2);
    }

    @GET
    //@Produces("text/xml")
    @Produces("application/json")
    public List<CoordenadasGps> getEventos() {
        return new ArrayList<CoordenadasGps>(eventosMap.values());
    }

    @Path("{id}")
    @GET
    //  @Produces("text/xml")
    @Produces("application/json")
    public CoordenadasGps getEvento(@PathParam("id") int id) {
        return eventosMap.get(id);
    }

    @POST
    @Path("/post")
    @Consumes("application/json")
    //@Consumes("text/xml")
   // @Consumes("text/plain")
    @Produces("text/plain")
    public String adicionaEvento(CoordenadasGps coordenadasGps) {
        // coordenadasGps.setId(eventosMap.size() + 1);
        CoordenadasGps get = eventosMap.get(1);
        get.setLatitude(coordenadasGps.getLatitude());
        get.setLongetude(coordenadasGps.getLongetude());
        return String.valueOf(coordenadasGps.getLatitude()) + " , " + String.valueOf(coordenadasGps.getLongetude()) + " adicionado.\n";
    }
    //
    //    @Path("{id}")
    //    @PUT
    //    @Consumes("text/xml")
    //    @Produces("text/plain")
    //    public String atualizaEvento(Evento evento, @PathParam("id") int id) {
    //        Evento atual = eventosMap.get(id);
    //        atual.setNome(evento.getNome());
    //        atual.setInicio(evento.getInicio());
    //        return evento.getNome() + " atualizada.\n";
    //    }
    //
    //    @Path("{id}")
    //    @DELETE
    //    @Produces("text/plain")
    //    public String removeEvento(@PathParam("id") int id) {
    //        eventosMap.remove(id);
    //        return "Evento removido.\n";
    //    }

    public static Map<Integer, CoordenadasGps> getEventosMap() {
        return eventosMap;
    }
}
