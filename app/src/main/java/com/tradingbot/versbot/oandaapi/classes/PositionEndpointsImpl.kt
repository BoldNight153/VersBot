package com.tradingbot.versbot.api.classes

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.tradingbot.versbot.oandaapi.config.OandaConfig
import com.tradingbot.versbot.api.interfaces.PositionEndpoints
import com.tradingbot.versbot.data.classes.ClosePositionResponse
import com.tradingbot.versbot.data.classes.OpenPositionsResponse
import com.tradingbot.versbot.data.classes.PositionDetailsResponse
import com.tradingbot.versbot.data.classes.PositionListResponse

class PositionEndpointsImpl(
    private val context: Context,
    override val baseUrl: String = OandaConfig.BASE_URL,
    override val accessToken: String = OandaConfig.ACCESS_TOKEN
) : PositionEndpoints {
    override val contentType: String = "application/json"

    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)
    private val gson = Gson()

    override fun getPositionList(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/positions"
        val request = object : StringRequest(
            Request.Method.GET, url,
            { response ->
                // Handle successful response
                val positionListResponse = gson.fromJson(response, PositionListResponse::class.java)
                println("Position List: ${positionListResponse.positions}")
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

    override fun getOpenPositions(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/openPositions"
        val request = object : StringRequest(
            Request.Method.GET, url,
            { response ->
                // Handle successful response
                val openPositionsResponse = gson.fromJson(response, OpenPositionsResponse::class.java)
                println("Open Positions: ${openPositionsResponse.positions}")
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

    override fun getPositionDetails(accountID: String, instrument: String) {
        val url = "$baseUrl/accounts/$accountID/positions/$instrument"
        val request = object : StringRequest(
            Request.Method.GET, url,
            { response ->
                // Handle successful response
                val positionDetailsResponse = gson.fromJson(response, PositionDetailsResponse::class.java)
                println("Position Details: ${positionDetailsResponse.position}")
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

    override fun closePosition(accountID: String, instrument: String) {
        val url = "$baseUrl/accounts/$accountID/positions/$instrument/close"
        val request = object : StringRequest(
            Request.Method.PUT, url,
            { response ->
                // Handle successful response
                val closePositionResponse = gson.fromJson(response, ClosePositionResponse::class.java)
                println("Close Position Response: $closePositionResponse")
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