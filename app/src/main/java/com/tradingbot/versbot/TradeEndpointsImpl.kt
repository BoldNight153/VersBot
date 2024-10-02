package com.tradingbot.versbot

import android.content.Context
import androidx.compose.foundation.layout.add
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.reflect.Method

class TradeEndpointsImpl(
    private val context: Context,
    override val baseUrl: String = OandaConfig.BASE_URL,
    override val accessToken: String = OandaConfig.ACCESS_TOKEN
) : TradeEndpoints {
    override val contentType: String = "application/json"

    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)

    override fun getTradeList(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/trades"
        val request = object : StringRequest(
            Request.Method.GET, url,
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

    override fun getOpenTrades(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/openTrades"
        val request = object : StringRequest(
            Request.Method.GET, url,
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

    override fun getTradeDetails(accountID: String, tradeID: String) {
        val url = "$baseUrl/accounts/$accountID/trades/$tradeID"
        val request = object : StringRequest(
            Request.Method.GET, url,
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

    override fun closeTrade(accountID: String, tradeID: String) {
        val url = "$baseUrl/accounts/$accountID/trades/$tradeID/close"
        // Implement API call using Volley for PUT request
    }

    override fun closeTrades(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/trades/close"
        // Implement API call using Volley for PUT request
    }
}