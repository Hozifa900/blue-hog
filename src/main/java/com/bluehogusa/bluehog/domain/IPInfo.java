package com.bluehogusa.bluehog.domain;

public class IPInfo {
    private String country;
    private String state;
    private String city;

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCuty() {
        return city;
    }

    @Override
    public String toString() {
        return "country:" + country + " state: " + state + " city: " + city;

    }
}
