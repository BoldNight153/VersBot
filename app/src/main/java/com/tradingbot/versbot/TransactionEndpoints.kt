package com.tradingbot.versbot

interface TransactionEndpoints : OandaApiService {
    fun getTransactionList(accountID: String): Unit
    fun getTransactionDetails(accountID: String, transactionID: String): Unit
    fun getTransactionRange(accountID: String): Unit
    fun getTransactionsSinceID(accountID: String): Unit
}