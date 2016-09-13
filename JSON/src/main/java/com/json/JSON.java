package com.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author alcir
 */
public class JSON {

    public static void main(String args[]) throws JSONException {

        JSONObject obj = new JSONObject();

        List list = new ArrayList();

        Map sList = new HashMap();
        sList.put("estabelecimento", 1);
        sList.put("subSetor", 12);
        list.add(sList);

        Map sList_ = new HashMap();
        sList_.put("estabelecimento", 32);
        sList_.put("subSetor", 22);
        list.add(sList_);

        obj.put("origem", list);

        JSONArray jArray = obj.getJSONArray("origem");

        List toList = JsonUtil.toList(jArray);

        String mStringArray[] = {"String1", "String2"};

        JSONArray mJSONArray = new JSONArray(Arrays.asList(mStringArray));

        for (int i = 0; i < mJSONArray.length(); i++) {
            JSONObject row = mJSONArray.getJSONObject(i);
        }

//        for (int ii = 0; ii < jArray.length(); ii++) {
//            System.out.println(jArray.getJSONObject(ii).getString("value"));
//        }
//        JSONObject jSONObject = new JSONObject();
//
//        
//        JSONArray jArray = obj.getJSONArray("list");
//        
//        JSONObject jSONObject_ = new JSONObject();
//        jSONObject_.put("estabelecimento", 12);
//        jSONObject_.put("subsetor", 11);
//        
//        jSONObject.put("origemList", jSONObject_);
//
////        JSONObject mes = new JSONObject();
////        mes.put("6", dia);
////        
////        JSONObject ano = jSONObject.put("2013", mes);
////        
////        JSONObject put2 = jSONObject.put("2014", "");
////        
////        JSONObject jsonObject = jSONObject.getJSONObject("2013");
//        String toString = jSONObject.toString();
//        System.out.println(toString);
//
//
//
//
//
//        JSONObject jSONObject2 = new JSONObject("{\"origemList\":{\"a\": \"b\", \"c\": \"d\", \"e\": \"f\" }}");        
//        jSONObject2.get("3");
        }
    }
