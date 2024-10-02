import android.content.Context
import androidx.compose.foundation.layout.add
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.tradingbot.versbot.OandaConfig
import com.tradingbot.versbot.PositionEndpoints

class PositionEndpointsImpl(
    private val context: Context,
    override val baseUrl: String = OandaConfig.BASE_URL,
    override val accessToken: String = OandaConfig.ACCESS_TOKEN
) : PositionEndpoints {
    override val contentType: String = "application/json"

    private val requestQueue: RequestQueue = Volley.newRequestQueue(context)

    override fun getPositionList(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/positions"
        val request = object : StringRequest(
            Request.Method.GET, url, // Corrected line
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

    override fun getOpenPositions(accountID: String) {
        val url = "$baseUrl/accounts/$accountID/openPositions"
        val request = object : StringRequest(
            Request.Method.GET, url, // Corrected line
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

    override fun getPositionDetails(accountID: String, instrument: String) {
        val url = "$baseUrl/accounts/$accountID/positions/$instrument"
        val request = object : StringRequest(
            Request.Method.GET, url, // Corrected line
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

    override fun closePosition(accountID: String, instrument: String) {
        val url = "$baseUrl/accounts/$accountID/positions/$instrument/close"
        // Implement API call using Volley for PUT request
    }
}