/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.chromis.pos.json.adapters;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author wetteifer
 * @param <T>
 */
public abstract class BaseAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {
    
    private static final DateFormat COMMON_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    protected String getFormattedDate(Date date) {
        if (date == null) {
            return null;
        }
        return COMMON_DATE_FORMAT.format(date);
    }
    
    protected Date getParsedDate(String date) {
        if (date == null) {
            return null;
        }
        try {
            return COMMON_DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    
}
