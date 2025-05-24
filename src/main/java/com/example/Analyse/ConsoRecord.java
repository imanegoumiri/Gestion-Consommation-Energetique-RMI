package com.example.Analyse;

import java.io.Serializable;

public class ConsoRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String timestamp;
    private double consommation;

    public ConsoRecord(String timestamp, double consommation) {
        this.timestamp = timestamp;
        this.consommation = consommation;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public double getConsommation() {
        return consommation;
    }

    @Override
    public String toString() {
        return "🕒 " + timestamp + " → " + consommation + " kW";
    }
}
