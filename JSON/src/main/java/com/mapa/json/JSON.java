package com.mapa.json;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author alcir
 */
public class JSON {

    public static void main(String args[]) throws JSONException {
        JSONObject jSONObject = new JSONObject();

        jSONObject.put("3", Boolean.TRUE);
        jSONObject.put("4", Boolean.TRUE);
        jSONObject.put("10", Boolean.TRUE);

//        JSONObject mes = new JSONObject();
//        mes.put("6", dia);
//        
//        JSONObject ano = jSONObject.put("2013", mes);
//        
//        JSONObject put2 = jSONObject.put("2014", "");
//        
//        JSONObject jsonObject = jSONObject.getJSONObject("2013");
        String toString = jSONObject.toString();
        System.out.println(toString);

        
        
        
        JSONObject jSONObject2 = new JSONObject(toString);        
        jSONObject2.get("3");
        

    }

}
