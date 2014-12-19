package com.geo.latlong;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alci
 */
public class Main {
    
    public static void main(String args[]){
        Date date = new Date(new Date().getTime() + ((1000 * 60 * 60 * 12) * -1));
        String format = new SimpleDateFormat("dd/MM/yyyy hh:mm").format(date);
        
        System.out.println(format);
    }
    
}
