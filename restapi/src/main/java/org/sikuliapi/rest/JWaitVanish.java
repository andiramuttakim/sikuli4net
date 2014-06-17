/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sikuliapi.rest;

import org.json.JSONObject;

import org.sikuliapi.rest.JPattern;

/**
 *
 * @author Alan
 */
public class JWaitVanish {
    
    public static final String field_jPattern = "jPattern";
    public static final String field_timeout = "timeout";
    public static final String field_patternDisappeared = "patternDisappeared";
    public static final String field_jResult = "jResult";
    
    public JPattern jPattern;
    public double timeout;
    public boolean patternDisappeared;
    public JResult jResult;
    
    public JWaitVanish(){
        patternDisappeared = false;
    }
    /*
        Parse the specified JSON string into a JWaitVanish object
    */
    public static JWaitVanish getJWaitVanish(String json){
        JSONObject jO = new JSONObject(json);
        JWaitVanish jWaitVanish = new JWaitVanish();
        jWaitVanish.jPattern = JPattern.getJPattern(jO.getJSONObject(field_jPattern).toString());
        jWaitVanish.timeout = jO.getInt(field_timeout);
        return jWaitVanish;
    }
    /*
        Parse the JWaitVanish object into a JSON string
    */
    public String toJson(){
        JSONObject jO = new JSONObject();
        jO.put(field_jPattern, new JSONObject(jPattern.toJson()));
        jO.put(field_timeout, timeout);
        jO.put(field_patternDisappeared, patternDisappeared);
        jO.put(field_jResult, new JSONObject(jResult.toJson()));
        return jO.toString();
    }
}
