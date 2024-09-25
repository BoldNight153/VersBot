//package com.tradingbot.smatestbot2;
//
//public class Account {
//    private String alias;
//    private String id;
//    private String status;
//
//    public Account(String alias, String id) {
//        this.alias = alias;
//        this.id = id;
//        this.status = "Stopped";
//    }
//
//    public String getAlias() {
//        return alias;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//}


package com.tradingbot.versbot;

public class Account {
    private String id;
    private String status;
    private String alias; // Add alias field

    public Account(String id, String status, String alias) {
        this.id = id;
        this.status = status;
        this.alias = alias; // Initialize alias
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlias() { // Add getAlias method
        return alias;
    }

    public void setAlias(String alias) { // Add setAlias method
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "Account{id='" + id + "', status='" + status + "', alias='" + alias + "'}";
    }
}
