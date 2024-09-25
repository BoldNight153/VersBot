//package com.tradingbot.smatestbot2;
//
//import java.util.Map;
//
//// OrderAPI class
//public class OrderAPI extends BaseAPI {
//
//    public OrderAPI(String baseUrl, String token) {
//        super(baseUrl, token);
//    }
//
//    public String createOrder(String accountId, Map<String, String> orderData) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/orders", "POST", orderData);
//    }
//
//    public String getOrders(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/orders", "GET", null);
//    }
//
//    public String getPendingOrders(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/pendingOrders", "GET", null);
//    }
//
//    public String getOrderDetails(String accountId, String orderSpecifier) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier, "GET", null);
//    }
//
//    public String replaceOrder(String accountId, String orderSpecifier, Map<String, String> orderData) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier, "PUT", orderData);
//    }
//
//    public String cancelOrder(String accountId, String orderSpecifier) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier + "/cancel", "PUT", null);
//    }
//
//    public String updateOrderClientExtensions(String accountId, String orderSpecifier, Map<String, String> clientExtensions) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier + "/clientExtensions", "PUT", clientExtensions);
//    }
//}

//package com.tradingbot.smatestbot2;
//
//import org.json.JSONObject;
//
//import java.util.Map;
//
//public class OrderAPI extends BaseAPI {
//
//    public OrderAPI(String baseUrl, String token) {
//        super(baseUrl, token);
//    }
//
//    public String createOrder(String accountId, Map<String, Object> orderData) throws Exception {
//        JSONObject jsonBody = new JSONObject(orderData);
//        return makeRequest("/v3/accounts/" + accountId + "/orders", "POST", jsonBody.toString());
//    }
//
//    public String getOrders(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/orders", "GET", null);
//    }
//
//    public String getPendingOrders(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/pendingOrders", "GET", null);
//    }
//
//    public String getOrderDetails(String accountId, String orderSpecifier) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier, "GET", null);
//    }
//
//    public String replaceOrder(String accountId, String orderSpecifier, Map<String, Object> orderData) throws Exception {
//        JSONObject jsonBody = new JSONObject(orderData);
//        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier, "PUT", jsonBody.toString());
//    }
//
//    public String cancelOrder(String accountId, String orderSpecifier) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier + "/cancel", "PUT", null);
//    }
//
//    public String updateOrderClientExtensions(String accountId, String orderSpecifier, Map<String, Object> clientExtensions) throws Exception {
//        JSONObject jsonBody = new JSONObject(clientExtensions);
//        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier + "/clientExtensions", "PUT", jsonBody.toString());
//    }
//}

//package com.tradingbot.smatestbot2;
//
//import org.json.JSONObject;
//
//import java.util.Map;
//
//public class OrderAPI extends BaseAPI {
//
//    public OrderAPI(String baseUrl, String token) {
//        super(baseUrl, token);
//    }
//
//    public String createOrder(String accountId, Map<String, Object> orderData) throws Exception {
//        JSONObject jsonBody = new JSONObject(orderData);
//        return makeRequest("/v3/accounts/" + accountId + "/orders", "POST", jsonBody.toString());
//    }
//
//    public String getOrders(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/orders", "GET", null);
//    }
//
//    public String getPendingOrders(String accountId) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/pendingOrders", "GET", null);
//    }
//
//    public String getOrderDetails(String accountId, String orderSpecifier) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier, "GET", null);
//    }
//
//    public String replaceOrder(String accountId, String orderSpecifier, Map<String, Object> orderData) throws Exception {
//        JSONObject jsonBody = new JSONObject(orderData);
//        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier, "PUT", jsonBody.toString());
//    }
//
//    public String cancelOrder(String accountId, String orderSpecifier) throws Exception {
//        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier + "/cancel", "PUT", null);
//    }
//
//    public String updateOrderClientExtensions(String accountId, String orderSpecifier, Map<String, Object> clientExtensions) throws Exception {
//        JSONObject jsonBody = new JSONObject(clientExtensions);
//        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier + "/clientExtensions", "PUT", jsonBody.toString());
//    }
//}

package com.tradingbot.versbot;

import android.content.Context;
import org.json.JSONObject;
import java.util.Map;

public class OrderAPI extends BaseAPI {

    public OrderAPI(String baseUrl, String token, Context context) {
        super(baseUrl, token, context);
    }

    public String createOrder(String accountId, Map<String, Object> orderData) throws Exception {
        JSONObject jsonBody = new JSONObject(orderData);
        return makeRequest("/v3/accounts/" + accountId + "/orders", "POST", jsonBody.toString());
    }

    public String getOrders(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/orders", "GET", null);
    }

    public String getPendingOrders(String accountId) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/pendingOrders", "GET", null);
    }

    public String getOrderDetails(String accountId, String orderSpecifier) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier, "GET", null);
    }

    public String replaceOrder(String accountId, String orderSpecifier, Map<String, Object> orderData) throws Exception {
        JSONObject jsonBody = new JSONObject(orderData);
        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier, "PUT", jsonBody.toString());
    }

    public String cancelOrder(String accountId, String orderSpecifier) throws Exception {
        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier + "/cancel", "PUT", null);
    }

    public String updateOrderClientExtensions(String accountId, String orderSpecifier, Map<String, Object> clientExtensions) throws Exception {
        JSONObject jsonBody = new JSONObject(clientExtensions);
        return makeRequest("/v3/accounts/" + accountId + "/orders/" + orderSpecifier + "/clientExtensions", "PUT", jsonBody.toString());
    }
}
