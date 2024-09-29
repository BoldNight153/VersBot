package com.tradingbot.versbot;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String id;
    private String guaranteedStopLossOrderMode;
    private boolean hedgingEnabled;
    private String createdTime;
    private String currency;
    private int createdByUserID;
    private String alias;
    private String marginRate;
    private String lastTransactionID;
    private String balance;
    private int openTradeCount;
    private int openPositionCount;
    private int pendingOrderCount;
    private String pl;
    private String resettablePL;
    private String resettablePLTime;
    private String financing;
    private String commission;
    private String dividendAdjustment;
    private String guaranteedExecutionFees;
    private List<JSONObject> orders;
    private List<JSONObject> positions;
    private String unrealizedPL;
    private String NAV;
    private String marginUsed;
    private String marginAvailable;
    private String positionValue;
    private String marginCloseoutUnrealizedPL;
    private String marginCloseoutNAV;
    private String marginCloseoutMarginUsed;
    private String marginCloseoutPositionValue;
    private String marginCloseoutPercent;
    private String withdrawalLimit;
    private String marginCallMarginUsed;
    private String marginCallPercent;
    private JSONObject accountInstruments;

    public Account(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString("id");
        this.guaranteedStopLossOrderMode = jsonObject.getString("guaranteedStopLossOrderMode");
        this.hedgingEnabled = jsonObject.getBoolean("hedgingEnabled");
        this.createdTime = jsonObject.getString("createdTime");
        this.currency = jsonObject.getString("currency");
        this.createdByUserID = jsonObject.getInt("createdByUserID");
        this.alias = jsonObject.getString("alias");
        this.marginRate = jsonObject.getString("marginRate");
        this.lastTransactionID = jsonObject.getString("lastTransactionID");
        this.balance = jsonObject.getString("balance");
        this.openTradeCount = jsonObject.getInt("openTradeCount");
        this.openPositionCount = jsonObject.getInt("openPositionCount");
        this.pendingOrderCount = jsonObject.getInt("pendingOrderCount");
        this.pl = jsonObject.getString("pl");
        this.resettablePL = jsonObject.getString("resettablePL");
        this.resettablePLTime = jsonObject.getString("resettablePLTime");
        this.financing = jsonObject.getString("financing");
        this.commission = jsonObject.getString("commission");
        this.dividendAdjustment = jsonObject.getString("dividendAdjustment");
        this.guaranteedExecutionFees = jsonObject.getString("guaranteedExecutionFees");
        this.orders = new ArrayList<>();
        JSONArray ordersArray = jsonObject.getJSONArray("orders");
        for (int i = 0; i < ordersArray.length(); i++) {
            this.orders.add(ordersArray.getJSONObject(i));
        }
        this.positions = new ArrayList<>();
        JSONArray positionsArray = jsonObject.getJSONArray("positions");
        for (int i = 0; i < positionsArray.length(); i++) {
            this.positions.add(positionsArray.getJSONObject(i));
        }
        this.unrealizedPL = jsonObject.getString("unrealizedPL");
        this.NAV = jsonObject.getString("NAV");
        this.marginUsed = jsonObject.getString("marginUsed");
        this.marginAvailable = jsonObject.getString("marginAvailable");
        this.positionValue = jsonObject.getString("positionValue");
        this.marginCloseoutUnrealizedPL = jsonObject.getString("marginCloseoutUnrealizedPL");
        this.marginCloseoutNAV = jsonObject.getString("marginCloseoutNAV");
        this.marginCloseoutMarginUsed = jsonObject.getString("marginCloseoutMarginUsed");
        this.marginCloseoutPositionValue = jsonObject.getString("marginCloseoutPositionValue");
        this.marginCloseoutPercent = jsonObject.getString("marginCloseoutPercent");
        this.withdrawalLimit = jsonObject.getString("withdrawalLimit");
        this.marginCallMarginUsed = jsonObject.getString("marginCallMarginUsed");
        this.marginCallPercent = jsonObject.getString("marginCallPercent");
    }

    // Getters and setters for all fields
    public String getId() {
        return id;
    }

    public String getGuaranteedStopLossOrderMode() {
        return guaranteedStopLossOrderMode;
    }

    public void setGuaranteedStopLossOrderMode(String guaranteedStopLossOrderMode) {
        this.guaranteedStopLossOrderMode = guaranteedStopLossOrderMode;
    }

    public boolean isHedgingEnabled() {
        return hedgingEnabled;
    }

    public void setHedgingEnabled(boolean hedgingEnabled) {
        this.hedgingEnabled = hedgingEnabled;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getCreatedByUserID() {
        return createdByUserID;
    }

    public void setCreatedByUserID(int createdByUserID) {
        this.createdByUserID = createdByUserID;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(String marginRate) {
        this.marginRate = marginRate;
    }

    public String getLastTransactionID() {
        return lastTransactionID;
    }

    public void setLastTransactionID(String lastTransactionID) {
        this.lastTransactionID = lastTransactionID;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public int getOpenTradeCount() {
        return openTradeCount;
    }

    public void setOpenTradeCount(int openTradeCount) {
        this.openTradeCount = openTradeCount;
    }

    public int getOpenPositionCount() {
        return openPositionCount;
    }

    public void setOpenPositionCount(int openPositionCount) {
        this.openPositionCount = openPositionCount;
    }

    public int getPendingOrderCount() {
        return pendingOrderCount;
    }

    public void setPendingOrderCount(int pendingOrderCount) {
        this.pendingOrderCount = pendingOrderCount;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public String getResettablePL() {
        return resettablePL;
    }

    public void setResettablePL(String resettablePL) {
        this.resettablePL = resettablePL;
    }

    public String getResettablePLTime() {
        return resettablePLTime;
    }

    public void setResettablePLTime(String resettablePLTime) {
        this.resettablePLTime = resettablePLTime;
    }

    public String getFinancing() {
        return financing;
    }

    public void setFinancing(String financing) {
        this.financing = financing;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getDividendAdjustment() {
        return dividendAdjustment;
    }

    public void setDividendAdjustment(String dividendAdjustment) {
        this.dividendAdjustment = dividendAdjustment;
    }

    public String getGuaranteedExecutionFees() {
        return guaranteedExecutionFees;
    }

    public void setGuaranteedExecutionFees(String guaranteedExecutionFees) {
        this.guaranteedExecutionFees = guaranteedExecutionFees;
    }

    public List<JSONObject> getOrders() {
        return orders;
    }

    public void setOrders(List<JSONObject> orders) {
        this.orders = orders;
    }

    public List<JSONObject> getPositions() {
        return positions;
    }

    public void setPositions(List<JSONObject> positions) {
        this.positions = positions;
    }

    public String getUnrealizedPL() {
        return unrealizedPL;
    }

    public void setUnrealizedPL(String unrealizedPL) {
        this.unrealizedPL = unrealizedPL;
    }

    public String getNAV() {
        return NAV;
    }

    public void setNAV(String NAV) {
        this.NAV = NAV;
    }

    public String getMarginUsed() {
        return marginUsed;
    }

    public void setMarginUsed(String marginUsed) {
        this.marginUsed = marginUsed;
    }

    public String getMarginAvailable() {
        return marginAvailable;
    }

    public void setMarginAvailable(String marginAvailable) {
        this.marginAvailable = marginAvailable;
    }

    public String getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(String positionValue) {
        this.positionValue = positionValue;
    }

    public String getMarginCloseoutUnrealizedPL() {
        return marginCloseoutUnrealizedPL;
    }

    public void setMarginCloseoutUnrealizedPL(String marginCloseoutUnrealizedPL) {
        this.marginCloseoutUnrealizedPL = marginCloseoutUnrealizedPL;
    }

    public String getMarginCloseoutNAV() {
        return marginCloseoutNAV;
    }

    public void setMarginCloseoutNAV(String marginCloseoutNAV) {
        this.marginCloseoutNAV = marginCloseoutNAV;
    }

    public String getMarginCloseoutMarginUsed() {
        return marginCloseoutMarginUsed;
    }

    public void setMarginCloseoutMarginUsed(String marginCloseoutMarginUsed) {
        this.marginCloseoutMarginUsed = marginCloseoutMarginUsed;
    }

    public String getMarginCloseoutPositionValue() {
        return marginCloseoutPositionValue;
    }

    public void setMarginCloseoutPositionValue(String marginCloseoutPositionValue) {
        this.marginCloseoutPositionValue = marginCloseoutPositionValue;
    }

    public String getMarginCloseoutPercent() {
        return marginCloseoutPercent;
    }

    public void setMarginCloseoutPercent(String marginCloseoutPercent) {
        this.marginCloseoutPercent = marginCloseoutPercent;
    }

    public String getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(String withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public String getMarginCallMarginUsed() {
        return marginCallMarginUsed;
    }

    public void setMarginCallMarginUsed(String marginCallMarginUsed) {
        this.marginCallMarginUsed = marginCallMarginUsed;
    }

    public String getMarginCallPercent() {
        return marginCallPercent;
    }

    public void setMarginCallPercent(String marginCallPercent) {
        this.marginCallPercent = marginCallPercent;
    }

    public JSONObject getAccountInstruments() {
        return accountInstruments;
    }

    public void setAccountInstruments(JSONObject accountInstruments) {
        this.accountInstruments = accountInstruments;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", guaranteedStopLossOrderMode='" + guaranteedStopLossOrderMode + '\'' +
                ", hedgingEnabled=" + hedgingEnabled +
                ", createdTime='" + createdTime + '\'' +
                ", currency='" + currency + '\'' +
                ", createdByUserID=" + createdByUserID +
                ", alias='" + alias + '\'' +
                ", marginRate='" + marginRate + '\'' +
                ", lastTransactionID='" + lastTransactionID + '\'' +
                ", balance='" + balance + '\'' +
                ", openTradeCount=" + openTradeCount +
                ", openPositionCount=" + openPositionCount +
                ", pendingOrderCount=" + pendingOrderCount +
                ", pl='" + pl + '\'' +
                ", resettablePL='" + resettablePL + '\'' +
                ", resettablePLTime='" + resettablePLTime + '\'' +
                ", financing='" + financing + '\'' +
                ", commission='" + commission + '\'' +
                ", dividendAdjustment='" + dividendAdjustment + '\'' +
                ", guaranteedExecutionFees='" + guaranteedExecutionFees + '\'' +
                ", orders=" + orders +
                ", positions=" + positions +
                ", unrealizedPL='" + unrealizedPL + '\'' +
                ", NAV='" + NAV + '\'' +
                ", marginUsed='" + marginUsed + '\'' +
                ", marginAvailable='" + marginAvailable + '\'' +
                ", positionValue='" + positionValue + '\'' +
                ", marginCloseoutUnrealizedPL='" + marginCloseoutUnrealizedPL + '\'' +
                ", marginCloseoutNAV='" + marginCloseoutNAV + '\'' +
                ", marginCloseoutMarginUsed='" + marginCloseoutMarginUsed + '\'' +
                ", marginCloseoutPositionValue='" + marginCloseoutPositionValue + '\'' +
                ", marginCloseoutPercent='" + marginCloseoutPercent + '\'' +
                ", withdrawalLimit='" + withdrawalLimit + '\'' +
                ", marginCallMarginUsed='" + marginCallMarginUsed + '\'' +
                ", marginCallPercent='" + marginCallPercent + '\'' +
                //", accountInstruments=" + accountInstruments +
                '}';
    }
}
