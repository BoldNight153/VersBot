package com.tradingbot.versbot

import android.content.Context
import androidx.compose.foundation.layout.add
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson // Added Gson import
import java.lang.reflect.Method

class TradeEndpointsImpl(
    private val context: Context,
    override val baseUrl: String = OandaConfig.BASE_URL,
    override val accessToken: String = OandaConfig.ACCESS_TOKEN
) : TradeEndpoints {
    override val contentType: String = "application/json"

    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)
    private val gson = Gson() // Added Gson instance

    override fun getTradeList(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/trades"
        val request = object : StringRequest(
            Request.Method.GET, url,
            { response ->
                // Handle successful response
                val tradeListResponse = gson.fromJson(response, TradeListResponse::class.java) // Added Gson parsing
                println("Trade List: ${tradeListResponse.trades}")
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
                val openTradesResponse = gson.fromJson(response, OpenTradesResponse::class.java) // Added Gson parsing
                println("Open Trades: ${openTradesResponse.trades}")
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
                val tradeDetailsResponse = gson.fromJson(response, TradeDetailsResponse::class.java) // Added Gson parsing
                println("Trade Details: ${tradeDetailsResponse.trade}")
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
        val request = object : StringRequest(
            Request.Method.PUT, url,
            { response ->
                // Handle successful response
                val closeTradeResponse = gson.fromJson(response, CloseTradeResponse::class.java)
                println("Close Trade Response: $closeTradeResponse")
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

    override fun closeTrades(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/trades/close"
        val request = object : StringRequest(
            Request.Method.PUT, url,
            { response ->
                // Handle successful response
                val closeTradesResponse = gson.fromJson(response, CloseTradesResponse::class.java)
                println("Close Trades Response: $closeTradesResponse")
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
}