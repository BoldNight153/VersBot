package com.tradingbot.versbot.api.classes

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.tradingbot.versbot.oandaapi.config.OandaConfig
import com.tradingbot.versbot.api.interfaces.PricingEndpoints
import com.tradingbot.versbot.data.classes.PriceListResponse

class PricingEndpointsImpl(
    private val context: Context,
    override val baseUrl: String = OandaConfig.BASE_URL,
    override val accessToken: String = OandaConfig.ACCESS_TOKEN
) : PricingEndpoints {
    override val contentType: String = "application/json"

    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)
    private val gson = Gson()

    override fun getPricing(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/pricing"
        val request = object : StringRequest(
            Request.Method.GET, url,
            { response ->
                // Handle successful response
                val priceListResponse = gson.fromJson(response, PriceListResponse::class.java)
                println("Price List: ${priceListResponse.prices}")
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