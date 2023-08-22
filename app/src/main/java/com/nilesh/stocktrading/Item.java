package com.nilesh.stocktrading;

public class Item {
    private String symbol;
    private String identifier;
    private String open;
    private String dayHigh;
    private String dayLow;
    private String lastPrice;
    private String previousClose;
    private static String change;
    private static String pChange;
    private String yearHigh;
    private String yearLow;
    private String totalTradedVolume;
    private String totalTradedValue;
    private String perChange365d;
    private String perChange30d;

    public Item() {
    }

    public Item(String symbol, String identifier, String open, String dayHigh, String dayLow,
                String lastPrice, String previousClose, String change, String pChange,
                String yearHigh, String yearLow, String totalTradedVolume, String totalTradedValue,
                String perChange365d, String perChange30d) {
        this.symbol = symbol;
        this.identifier = identifier;
        this.open = open;
        this.dayHigh = dayHigh;
        this.dayLow = dayLow;
        this.lastPrice = lastPrice;
        this.previousClose = previousClose;
        this.change = change;
        this.pChange = pChange;
        this.yearHigh = yearHigh;
        this.yearLow = yearLow;
        this.totalTradedVolume = totalTradedVolume;
        this.totalTradedValue = totalTradedValue;
        this.perChange365d = perChange365d;
        this.perChange30d = perChange30d;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getOpen() {
        return open;
    }

    public String getDayHigh() {
        return dayHigh;
    }

    public String getDayLow() {
        return dayLow;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public String getPreviousClose() {
        return previousClose;
    }

    public static String getChange() {
        return change;
    }

    public static String getPChange() {
        return pChange;
    }

    public String getYearHigh() {
        return yearHigh;
    }

    public String getYearLow() {
        return yearLow;
    }

    public String getTotalTradedVolume() {
        return totalTradedVolume;
    }

    public String getTotalTradedValue() {
        return totalTradedValue;
    }

    public String getPerChange365d() {
        return perChange365d;
    }

    public String getPerChange30d() {
        return perChange30d;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public void setDayHigh(String dayHigh) {
        this.dayHigh = dayHigh;
    }

    public void setDayLow(String dayLow) {
        this.dayLow = dayLow;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public void setpChange(String pChange) {
        this.pChange = pChange;
    }

    public void setYearHigh(String yearHigh) {
        this.yearHigh = yearHigh;
    }

    public void setYearLow(String yearLow) {
        this.yearLow = yearLow;
    }

    public void setTotalTradedVolume(String totalTradedVolume) {
        this.totalTradedVolume = totalTradedVolume;
    }

    public void setTotalTradedValue(String totalTradedValue) {
        this.totalTradedValue = totalTradedValue;
    }

    public void setPerChange365d(String perChange365d) {
        this.perChange365d = perChange365d;
    }

    public void setPerChange30d(String perChange30d) {
        this.perChange30d = perChange30d;
    }
}
