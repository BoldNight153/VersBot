package com.tradingbot.versbot.api.classes

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.tradingbot.versbot.oandaapi.config.OandaConfig
import com.tradingbot.versbot.api.interfaces.TransactionEndpoints

class TransactionEndpointsImpl(
    private val context: Context,
    override val baseUrl: String = OandaConfig.BASE_URL,
    override val accessToken: String = OandaConfig.ACCESS_TOKEN
) : TransactionEndpoints {
    override val contentType: String = "application/json"

    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)

    override fun getTransactionList(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/transactions"
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

    override fun getTransactionDetails(accountID: String, transactionID: String) {
        val url = "$baseUrl/accounts/$accountID/transactions/$transactionID"
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

    override fun getTransactionRange(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/transactions/range"
        // Implement API call using Volley for GET request with query parameters
    }

    override fun getTransactionsSinceID(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/transactions/sinceid"
        // Implement API call using Volley for GET request with query parameters
    }
}