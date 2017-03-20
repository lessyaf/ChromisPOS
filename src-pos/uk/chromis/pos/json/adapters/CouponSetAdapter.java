/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.chromis.pos.json.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Set;
import uk.chromis.pos.json.util.JsonObjectWrapper;
import uk.chromis.pos.ticket.CouponLine;
import uk.chromis.pos.ticket.CouponSet;

/**
 *
 * @author wetteifer
 */
public class CouponSetAdapter extends BaseAdapter<CouponSet> {

    private static final String LINES_PROPERTY = "Lines";    
    
    @Override
    public JsonElement serialize(CouponSet set, Type type, JsonSerializationContext context) {
        if (set == null) {
            return JsonNull.INSTANCE;
        }
        
        JsonObject object = new JsonObject();
        
        object.add(LINES_PROPERTY, context.serialize(set.getLines()));
        
        return object;
    }

    @Override
    public CouponSet deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        if (element.isJsonNull()) {
            return null;
        }
        
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        CouponSet set = new CouponSet(
                wrapper.getObject(LINES_PROPERTY, new TypeToken<Set<CouponLine>>(){}.getType()));
        
        return set;
    }
    
}
