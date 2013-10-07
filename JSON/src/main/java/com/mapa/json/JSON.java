package com.mapa.json;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author alcir
 */
public class JSON {
    
    public static void main(String args[]) throws JSONException{
        JSONObject jSONObject = new JSONObject();
        
        JSONObject dia = new JSONObject();
        dia.put("3", Boolean.TRUE);
        dia.put("4", Boolean.TRUE);
        dia.put("10", Boolean.TRUE);

        
        JSONObject mes = new JSONObject();
        mes.put("6", dia);
        
        JSONObject ano = jSONObject.put("2013", mes);
        
        JSONObject put2 = jSONObject.put("2014", "");
        
        JSONObject jsonObject = jSONObject.getJSONObject("2013");
        
        
        String toString = jSONObject.toString();
        
        System.out.println(toString);
    }
    
}
