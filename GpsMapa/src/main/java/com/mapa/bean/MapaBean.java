package com.mapa.bean;

import com.mapa.bean.webService.EventoResource;
import com.mapa.evento.CoordenadasGps;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@RequestScoped
@ManagedBean()
public class MapaBean implements Serializable {

    private MapModel mapModel = new DefaultMapModel();

    public MapaBean() {
        mapModel = new DefaultMapModel();

        for (CoordenadasGps coordenadasGps : EventoResource.getEventosMap().values()) {
            LatLng coord1 = new LatLng(coordenadasGps.getLatitude(), coordenadasGps.getLongetude());
            Marker marker = new Marker(coord1);
            marker.setDraggable(false);
            mapModel.addOverlay(marker);
        }
    }

    public MapModel getMapModel() {
        return mapModel;
    }
}
