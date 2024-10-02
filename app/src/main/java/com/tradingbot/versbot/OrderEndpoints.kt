package com.tradingbot.versbot

interface OrderEndpoints : OandaApiService {
    fun getOrderList(accountID: String): Unit
    fun getPendingOrders(accountID: String): Unit
    fun getOrderDetails(accountID: String, orderID: String): Unit
    fun createOrder(accountID: String): Unit
    fun replaceOrder(accountID: String, orderID: String): Unit
    fun cancelOrder(accountID: String, orderID: String): Unit
    fun cancelOrders(accountID: String): Unit
}