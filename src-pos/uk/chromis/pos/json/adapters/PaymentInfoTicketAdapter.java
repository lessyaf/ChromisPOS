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
import uk.chromis.pos.payment.PaymentInfoTicket;

/**
 *
 * @author wetteifer
 */
public class PaymentInfoTicketAdapter extends BaseAdapter<PaymentInfoTicket> {

    private static final String TICKET_PROPERTY = "Ticket";
    private static final String NAME_PROPERTY = "Name";
    private static final String TRANSACTION_ID_PROPERTY = "TransactionId";
    
    @Override
    public JsonElement serialize(PaymentInfoTicket payment, Type type, JsonSerializationContext context) {
        if (payment == null) {
            return JsonNull.INSTANCE;
        }
        
        JsonObject object = new JsonObject();
        
        object.addProperty(PaymentInfoAdapter.TYPE_PROPERTY, PaymentInfoTicket.class.getSimpleName());
        object.addProperty(TICKET_PROPERTY, payment.getTotal());
        object.addProperty(NAME_PROPERTY, payment.getName());
        object.addProperty(TRANSACTION_ID_PROPERTY, payment.getTransactionID());
        
        return object;
    }

    @Override
    public PaymentInfoTicket deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        if (element.isJsonNull()) {
            return null;
        }
        
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        PaymentInfoTicket payment = new PaymentInfoTicket(
                wrapper.getDouble(TICKET_PROPERTY),
                wrapper.getString(NAME_PROPERTY),
                wrapper.getString(TRANSACTION_ID_PROPERTY));
        
        return payment;
    }
    
}
