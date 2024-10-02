package com.tradingbot.versbot

interface AccountEndpoints : OandaApiService {
    fun getAccountList(): Unit
    fun getAccountDetails(accountId: String): Unit
    fun getAccountSummary(accountId: String): Unit
    fun getAccountInstruments(accountId: String): Unit
    fun patchAccountConfiguration(accountId: String): Unit
    fun postChangeAccountAlias(accountId: String): Unit
}