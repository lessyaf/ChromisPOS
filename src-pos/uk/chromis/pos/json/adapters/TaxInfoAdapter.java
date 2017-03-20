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
import uk.chromis.pos.ticket.TaxInfo;

/**
 *
 * @author wetteifer
 */
public class TaxInfoAdapter extends BaseAdapter<TaxInfo> {

    private static final String ID_PROPERTY = "Id";
    private static final String NAME_PROPERTY = "Name";
    private static final String TAX_CATEGORY_ID_PROPERTY = "TaxCategoryId";
    private static final String TAX_CUSTOMER_CATEGORY_ID_PROPERTY = "TaxCustomerCategoryId";
    private static final String PARENT_ID_PROPERTY = "ParentId";
    private static final String RATE_PROPERTY = "Rate";
    private static final String CASCADE_PROPERTY = "Cascade";
    private static final String ORDER_PROPERTY = "Order";
    
    @Override
    public JsonElement serialize(TaxInfo tax, Type type, JsonSerializationContext context) {
        if (tax == null) {
            return JsonNull.INSTANCE;
        }
        
        JsonObject object = new JsonObject();
        
        object.addProperty(ID_PROPERTY, tax.getId());
        object.addProperty(NAME_PROPERTY, tax.getName());
        object.addProperty(TAX_CATEGORY_ID_PROPERTY, tax.getTaxCategoryID());
        object.addProperty(TAX_CUSTOMER_CATEGORY_ID_PROPERTY, tax.getTaxCustCategoryID());
        object.addProperty(PARENT_ID_PROPERTY, tax.getParentID());
        object.addProperty(RATE_PROPERTY, tax.getRate());
        object.addProperty(CASCADE_PROPERTY, tax.isCascade());
        object.addProperty(ORDER_PROPERTY, tax.getOrder());
        
        return object;
    }

    @Override
    public TaxInfo deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        if (element.isJsonNull()) {
            return null;
        }
        
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        TaxInfo tax = new TaxInfo(
                wrapper.getString(ID_PROPERTY),
                wrapper.getString(NAME_PROPERTY),
                wrapper.getString(TAX_CATEGORY_ID_PROPERTY),
                wrapper.getString(TAX_CUSTOMER_CATEGORY_ID_PROPERTY),
                wrapper.getString(PARENT_ID_PROPERTY),
                wrapper.getDouble(RATE_PROPERTY),
                wrapper.getBoolean(CASCADE_PROPERTY),
                wrapper.getInteger(ORDER_PROPERTY));
        
        return tax;
    }
    
}
