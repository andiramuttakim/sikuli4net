/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sikuliapi.rest;

import org.json.JSONObject;
import org.sikuli.script.Pattern;

/**
 *
 * @author Alan
 */
public class JPattern {
    public static final String field_imagePath = "imagePath";
    public static final String field_offset_x = "offset_x";
    public static final String field_offset_y = "offset_y";
    public static final String field_similar = "similar";
    
    public String imagePath;
    public int offset_x;
    public int offset_y;
    public float similar;
    
    public JPattern(){
        
    }
    /*
        Parse the passed string into a JPattern object
    */
    public static JPattern getJPattern(String json){
        JSONObject jO = new JSONObject(json);
        JPattern jP = new JPattern();
        jP.imagePath = jO.getString(field_imagePath);
        jP.offset_x = jO.getInt(field_offset_x);
        jP.offset_y = jO.getInt(field_offset_y);
        jP.similar = (float) jO.getDouble(field_similar);
        return jP;
    }
    /*
        Parse the JPattern object into a JSON string
    */
    public String toJson(){
        JSONObject jO = new JSONObject();
        jO.put(field_imagePath, imagePath);
        jO.put(field_offset_x, offset_x);
        jO.put(field_offset_y, offset_y);
        jO.put(field_similar, similar);
        return jO.toString();
    }
    /*
        Create a Sikuli Pattern object from this JPattern
    */
    public Pattern toPattern(){
        Pattern pattern = new Pattern(imagePath);
        pattern.targetOffset(offset_x, offset_y);
        pattern.similar(similar);
        return pattern;
    }
}
