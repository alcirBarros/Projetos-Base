package com.geo.localizacao;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alci
 */
public class DistanceMatrixResponse {
    
    private String status;
    
    private String origin_address;

    private String destination_address;
    
    private List<Row> row = new ArrayList<Row>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrigin_address() {
        return origin_address;
    }

    public void setOrigin_address(String origin_address) {
        this.origin_address = origin_address;
    }

    public String getDestination_address() {
        return destination_address;
    }

    public void setDestination_address(String destination_address) {
        this.destination_address = destination_address;
    }

    public List<Row> getRow() {
        return row;
    }

    public void setRow(List<Row> row) {
        this.row = row;
    }
    
    
}



