package com.tradingbot.versbot

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import org.json.JSONObject

class AccountEndpointsImpl(
    private val context: Context,
    override val baseUrl: String = OandaConfig.BASE_URL,
    override val accessToken: String = OandaConfig.ACCESS_TOKEN
) : AccountEndpoints {
    override val contentType: String = "application/json"

    private val requestQueue: com.android.volley.RequestQueue = com.android.volley.toolbox.Volley.newRequestQueue(context)
    private val gson = Gson()

    override fun getAccountList() {
        val url = "$baseUrl/accounts"
        val request = object : StringRequest(
            Request.Method.GET, url,
            { response ->
                // Handle successful response
                val accountListResponse = gson.fromJson(response, AccountListResponse::class.java)
                println("Account List: ${accountListResponse.accounts}")
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
        val request = object : StringRequest(
            Request.Method.GET, url,
            { response ->
                // Handle successful response
                val accountDetailsResponse = gson.fromJson(response, AccountDetailsResponse::class.java)
                println("Account Details: ${accountDetailsResponse.account}")
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
        val request = object : StringRequest(
            Request.Method.GET, url,
            { response ->
                // Handle successful response
                val accountSummaryResponse = gson.fromJson(response, AccountSummaryResponse::class.java)
                println("Account Summary: ${accountSummaryResponse.account}")
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
        val request = object : StringRequest(
            Request.Method.GET, url,
            { response ->
                // Handle successful response
                val accountInstrumentsResponse = gson.fromJson(response, AccountInstrumentsResponse::class.java)
                println("Account Instruments: ${accountInstrumentsResponse.instruments}")
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
        val params = JSONObject()
        // Add your parameters for the PATCH request here
        val request = object : JsonObjectRequest(
            Request.Method.PATCH, url, params,
            { response ->
                // Handle successful response
                val patchAccountConfigurationResponse = gson.fromJson(response.toString(), PatchAccountConfigurationResponse::class.java)
                println("Patch Account Configuration Response: $patchAccountConfigurationResponse")
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