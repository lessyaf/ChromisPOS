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
import uk.chromis.pos.payment.PaymentInfoCash_original;

/**
 *
 * @author wetteifer
 */
public class PaymentInfoCashOriginalAdapter extends BaseAdapter<PaymentInfoCash_original> {

    private static final String TOTAL_PROPERTY = "Total";
    private static final String PAID_PROPERTY = "Paid";
    
    @Override
    public JsonElement serialize(PaymentInfoCash_original payment, Type type, JsonSerializationContext context) {
        if (payment == null) {
            return JsonNull.INSTANCE;
        }
        
        JsonObject object = new JsonObject();
        
        object.addProperty(PaymentInfoAdapter.TYPE_PROPERTY, PaymentInfoCash_original.class.getSimpleName());
        object.addProperty(TOTAL_PROPERTY, payment.getTotal());
        object.addProperty(PAID_PROPERTY, payment.getPaid());
        
        return object;
    }

    @Override
    public PaymentInfoCash_original deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        if (element.isJsonNull()) {
            return null;
        }
        
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        PaymentInfoCash_original payment = new PaymentInfoCash_original(
                wrapper.getDouble(TOTAL_PROPERTY),
                wrapper.getDouble(PAID_PROPERTY));
        
        return payment;
    }
    
}
