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
import java.lang.reflect.Type;
import uk.chromis.pos.json.util.JsonObjectWrapper;
import uk.chromis.pos.ticket.CouponLine;

/**
 *
 * @author wetteifer
 */
public class CouponLineAdapter extends BaseAdapter<CouponLine> {

    private static final String ID_PROPERTY = "Id";
    private static final String LINE_NUMBER_PROPERTY = "LineNumber";
    private static final String LINE_TEXT_PROPERTY = "LineText";
    
    @Override
    public JsonElement serialize(CouponLine coupon, Type type, JsonSerializationContext context) {
        if (coupon == null) {
            return JsonNull.INSTANCE;
        }
        
        JsonObject object = new JsonObject();
        
        object.addProperty(ID_PROPERTY, coupon.getid());
        object.addProperty(LINE_NUMBER_PROPERTY, coupon.getlinenumber());
        object.addProperty(LINE_TEXT_PROPERTY, coupon.gettext());
        
        return object;
    }

    @Override
    public CouponLine deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        if (element.isJsonNull()) {
            return null;
        }
        
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        CouponLine coupon = new CouponLine(
                wrapper.getString(ID_PROPERTY),
                wrapper.getInteger(LINE_NUMBER_PROPERTY),
                wrapper.getString(LINE_TEXT_PROPERTY));
        
        return coupon;
    }
    
}
