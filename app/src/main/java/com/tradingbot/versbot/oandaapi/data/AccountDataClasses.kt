package com.tradingbot.versbot.data.classes

data class AccountListResponse(
    val accounts: List<Account>,
    val lastTransactionID: String
)

data class Account(
    val id: String,
    val alias: String,
    val currency: String,
    val balance: String,
    val createdByUserID: Int,
    val createdTime: String,
    val guaranteedStopLossOrderMode: String,
    val pl: String,
    val resettablePL: String,
    val resettablePLTime: String,
    val financing: String,
    val commission: String,
    val guaranteedExecutionFees: String,
    val marginRate: String,
    val marginCallEnterTime: String? = null,
    val marginCallExtensionCount: Int,
    val lastMarginCallExtensionTime: String? = null,
    val openTradeCount: Int,
    val openPositionCount: Int,
    val pendingOrderCount: Int,
    val hedgingEnabled: Boolean,
    val unrealizedPL: String,
    val NAV: String,
    val marginUsed: String,
    val marginAvailable: String,
    val positionValue: String,
    val marginCloseoutUnrealizedPL: String,
    val marginCloseoutNAV: String,
    val marginCloseoutMarginUsed: String,
    val marginCloseoutPercent: String? = null,
    val marginCloseoutPositionValue: String,
    val withdrawalLimit: String,
    val marginCallMarginUsed: String? = null,
    val marginCallPercent: String? = null
)

data class AccountDetailsResponse(
    val account: Account,
    val lastTransactionID: String
)

data class AccountSummaryResponse(
    val account: AccountSummary,
    val lastTransactionID: String
)

data class AccountSummary(
    val id: String,
    val alias: String,
    val currency: String,
    val balance: String,
    val createdByUserID: Int,
    val createdTime: String,
    val guaranteedStopLossOrderMode: String,
    val pl: String,
    val resettablePL: String,
    val resettablePLTime: String,
    val financing: String,
    val commission: String,
    val guaranteedExecutionFees: String,
    val marginRate: String,
    val marginCallEnterTime: String? = null,
    val marginCallExtensionCount: Int,
    val lastMarginCallExtensionTime: String? = null,
    val openTradeCount: Int,
    val openPositionCount: Int,
    val pendingOrderCount: Int,
    val hedgingEnabled: Boolean,
    val unrealizedPL: String,
    val NAV: String,
    val marginUsed: String,
    val marginAvailable: String,
    val positionValue: String,
    val marginCloseoutUnrealizedPL: String,
    val marginCloseoutNAV: String,
    val marginCloseoutMarginUsed: String,
    val marginCloseoutPercent: String? = null,
    val marginCloseoutPositionValue: String,
    val withdrawalLimit: String,
    val marginCallMarginUsed: String? = null,
    val marginCallPercent: String? = null
)

data class AccountInstrumentsResponse(
    val instruments: List<Instrument>,
    val lastTransactionID: String
)

data class Instrument(
    val name: String,
    val type: String,
    val displayName: String,
    val pipLocation: Int,
    val displayPrecision: Int,
    val tradeUnitsPrecision: Int,
    val minimumTradeSize: String,
    val maximumTrailingStopDistance: String,
    val minimumTrailingStopDistance: String,
    val maximumPositionSize: String,
    val maximumOrderUnits: String,
    val marginRate: String,
    val commission: String
)

data class PatchAccountConfigurationResponse(
    val clientConfigureTransaction: PatchAccountConfigurationTransaction,
    val lastTransactionID: String
)

data class PatchAccountConfigurationTransaction(
    val id: String,
    val time: String,
    val userID: Int,
    val accountID: String,
    val batchID: String,
    val requestID: String,
    val type: String,
    val alias: String,
    val marginRate: String
)
