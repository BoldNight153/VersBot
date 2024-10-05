package com.tradingbot.versbot.data.classes

data class OrderListResponse(
    val orders: List<Order>,
    val lastTransactionID: String
)

data class Order(
    val id: String,
    val createTime: String,
    val state: String,
    val type: String,
    val instrument: String,
    val units: String,
    val price: String?,
    val timeInForce: String,
    val gtdTime: String?,
    val positionFill: String,
    val triggerCondition: String,
    val takeProfitOnFill: TakeProfitOnFill?,
    val stopLossOnFill: StopLossOnFill?,
    val trailingStopLossOnFill: TrailingStopLossOnFill?,
    val tradeClose: TradeClose?,
    val clientExtensions: ClientExtensions?,
    val fillingTransactionID: String?,
    val filledTime: String?,
    val tradeOpenedID: String?,
    val tradeReducedID: String?,
    val tradeClosedIDs: List<String>?,
    val cancellingTransactionID: String?,
    val cancelledTime: String?,
    val replacesOrderID: String?,
    val replacedByOrderID: String?
)

data class PendingOrdersResponse(
    val pendingOrders: List<Order>,
    val lastTransactionID: String
)

data class OrderDetailsResponse(
    val order: Order,
    val lastTransactionID: String
)

data class CreateOrderResponse(
    val orderCreateTransaction: Transaction,
    val orderFillTransaction: Transaction?,
    val orderCancelTransaction: Transaction?,
    val orderReissueTransaction: Transaction?,
    val orderReissueRejectTransaction: Transaction?,
    val relatedTransactionIDs: List<String>,
    val lastTransactionID: String
)

data class CancelOrderResponse(
    val orderCancelTransaction: Transaction,
    val relatedTransactionIDs: List<String>,
    val lastTransactionID: String
)

data class ReplaceOrderResponse(
    val orderCancelTransaction: Transaction,
    val orderCreateTransaction: Transaction,
    val orderFillTransaction: Transaction?,
    val orderReissueTransaction: Transaction?,
    val orderReissueRejectTransaction: Transaction?,
    val relatedTransactionIDs: List<String>,
    val lastTransactionID: String
)