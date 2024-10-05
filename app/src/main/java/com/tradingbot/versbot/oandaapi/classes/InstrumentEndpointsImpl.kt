package com.tradingbot.versbot.api.classes

import android.content.Context
import com.google.gson.Gson
import com.tradingbot.versbot.oandaapi.config.OandaConfig
import com.tradingbot.versbot.api.interfaces.InstrumentEndpoints
import com.tradingbot.versbot.data.classes.AccountInstrumentsResponse
import com.tradingbot.versbot.data.classes.CandlesResponse
import com.tradingbot.versbot.data.classes.OrderBookResponse // Added import
import com.tradingbot.versbot.data.classes.PositionBookResponse // Added import

class InstrumentEndpointsImpl(
    private val context: Context,
    override val baseUrl: String = OandaConfig.BASE_URL,
    override val accessToken: String = OandaConfig.ACCESS_TOKEN
) : InstrumentEndpoints {
    override val contentType: String = "application/json"

    private val requestQueue: com.android.volley.RequestQueue = com.android.volley.toolbox.Volley.newRequestQueue(context)
    private val gson = Gson()

    override fun getInstruments(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/instruments"
        val request = object : com.android.volley.toolbox.StringRequest(
            Method.GET, url,
            { response ->
                // Handle successful response
                val instrumentsResponse = gson.fromJson(response, AccountInstrumentsResponse::class.java)
                println("Instruments: ${instrumentsResponse.instruments}")
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

    override fun getCandles(instrument: String) {
        val url = "$baseUrl/instruments/$instrument/candles"
        val request = object : com.android.volley.toolbox.StringRequest(
            Method.GET, url,
            { response ->
                // Handle successful response
                val candlesResponse = gson.fromJson(response, CandlesResponse::class.java)
                println("Candles: ${candlesResponse.candles}")
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

    override fun getOrderBook(instrument: String) {
        val url = "$baseUrl/instruments/$instrument/orderBook"
        val request = object : com.android.volley.toolbox.StringRequest(
            Method.GET, url,
            { response ->
                // Handle successful response
                val orderBookResponse = gson.fromJson(response, OrderBookResponse::class.java)
                println("Order Book: ${orderBookResponse.orderBook}")
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

    override fun getPositionBook(instrument: String) {
        val url = "$baseUrl/instruments/$instrument/positionBook"
        val request = object : com.android.volley.toolbox.StringRequest(
            Method.GET, url,
            { response ->
                // Handle successful response
                val positionBookResponse = gson.fromJson(response, PositionBookResponse::class.java)
                println("Position Book: ${positionBookResponse.positionBook}")
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