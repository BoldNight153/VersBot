package com.tradingbot.versbot

import android.content.Context
import androidx.compose.foundation.layout.add
import java.lang.reflect.Method

class OrderEndpointsImpl(
    private val context: Context,
    override val baseUrl: String = OandaConfig.BASE_URL,
    override val accessToken: String = OandaConfig.ACCESS_TOKEN
) : OrderEndpoints {
    override val contentType: String = "application/json"

    private val requestQueue: com.android.volley.RequestQueue = com.android.volley.toolbox.Volley.newRequestQueue(context)

    override fun getOrderList(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/orders"
        val request = object : com.android.volley.toolbox.StringRequest(
            Method.GET, url,
            { response ->
                // Handle successful response
                println("Response: $response")
            },
            { error ->
                // Handle error
                println("Error: ${error.message}")
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = contentType
                headers["Authorization"] = "Bearer $accessToken"
                return headers
            }
        }
        requestQueue.add(request)
    }

    override fun getPendingOrders(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/pendingOrders"
        val request = object : com.android.volley.toolbox.StringRequest(
            Method.GET, url,
            { response ->
                // Handle successful response
                println("Response: $response")
            },
            { error ->
                // Handle error
                println("Error: ${error.message}")
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = contentType
                headers["Authorization"] = "Bearer $accessToken"
                return headers
            }
        }
        requestQueue.add(request)
    }

    override fun getOrderDetails(accountID: String, orderID: String) {
        val url = "$baseUrl/accounts/$accountID/orders/$orderID"
        val request = object : com.android.volley.toolbox.StringRequest(
            Method.GET, url,
            { response ->
                // Handle successful response
                println("Response: $response")
            },
            { error ->
                // Handle error
                println("Error: ${error.message}")
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = contentType
                headers["Authorization"] = "Bearer $accessToken"
                return headers
            }
        }
        requestQueue.add(request)
    }

    override fun createOrder(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/orders"
        // Implement API call using Volley for POST request
    }

    override fun replaceOrder(accountID: String, orderID: String) {
        val url = "$baseUrl/accounts/$accountID/orders/$orderID"
        // Implement API call using Volley for PUT request
    }

    override fun cancelOrder(accountID: String, orderID: String) {
        val url = "$baseUrl/accounts/$accountID/orders/$orderID/cancel"
        val request = object : com.android.volley.toolbox.StringRequest(
            Method.PUT, url,
            { response ->
                // Handle successful response
                println("Response: $response")
            },
            { error ->
                // Handle error
                println("Error: ${error.message}")
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Content-Type"] = contentType
                headers["Authorization"] = "Bearer $accessToken"
                return headers
            }
        }
        requestQueue.add(request)
    }

    override fun cancelOrders(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/orders/cancel"
        // Implement API call using Volley for PUT request
    }
}