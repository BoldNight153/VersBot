package com.tradingbot.versbot;

import android.content.Context;
import org.json.JSONObject;
import java.util.Map;

public class OrderAPI extends BaseAPI {

    public OrderAPI(Context context) {
        super(context);
    }

    public String createOrder(String accountId, Map<String, Object> orderData) throws Exception {
        JSONObject jsonBody = new JSONObject(orderData);
        return makeRequest("/v3/accounts/" + accountId + "/orders", "POST", jsonBody.toString(), false);
    }

    public String getOrders(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/orders", "GET", null, false);
    }

    public String getPendingOrders(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/pendingOrders", "GET", null, false);
    }

    public String getOrderDetails(String accountId, String orderSpecifier) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier, "GET", null, false);
    }

    public String replaceOrder(String accountId, String orderSpecifier, Map<String, Object> orderData) throws Exception {
        JSONObject jsonBody = new JSONObject(orderData);
        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier, "PUT", jsonBody.toString(), false);
    }

    public String cancelOrder(String accountId, String orderSpecifier) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier + "/cancel", "PUT", null, false);
    }

    public String updateOrderClientExtensions(String accountId, String orderSpecifier, Map<String, Object> clientExtensions) throws Exception {
        JSONObject jsonBody = new JSONObject(clientExtensions);
        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier + "/clientExtensions", "PUT", jsonBody.toString(), false);
    }
}
