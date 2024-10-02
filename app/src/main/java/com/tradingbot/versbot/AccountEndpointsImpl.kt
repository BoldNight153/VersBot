package com.tradingbot.versbot

import android.content.Context
import androidx.compose.foundation.layout.add
import com.android.volley.Request
import java.lang.reflect.Method

class AccountEndpointsImpl(
    private val context: Context,
    override val baseUrl: String = OandaConfig.BASE_URL,
    override val accessToken: String = OandaConfig.ACCESS_TOKEN
) : AccountEndpoints {
    override val contentType: String = "application/json"

    private val requestQueue: com.android.volley.RequestQueue = com.android.volley.toolbox.Volley.newRequestQueue(context)

    override fun getAccountList() {
        val url = "$baseUrl/accounts"
        val request = object : com.android.volley.toolbox.StringRequest(
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

    override fun getAccountDetails(accountId: String) {
        val url = "$baseUrl/accounts/$accountId"
        val request = object : com.android.volley.toolbox.StringRequest(
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

    override fun getAccountSummary(accountId: String) {
        val url = "$baseUrl/accounts/$accountId/summary"
        val request = object : com.android.volley.toolbox.StringRequest(
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

    override fun getAccountInstruments(accountId: String) {
        val url = "$baseUrl/accounts/$accountId/instruments"
        val request = object : com.android.volley.toolbox.StringRequest(
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

    override fun patchAccountConfiguration(accountId: String) {
        val url = "$baseUrl/accounts/$accountId/configuration"
        // Implement API call using Volley for PATCH request
    }

    override fun postChangeAccountAlias(accountId: String) {
        val url = "$baseUrl/accounts/$accountId/alias"
        // Implement API call using Volley for POST request
    }
}