package com.bluehogusa.bluehog.domain;

public class IPInfo {
    private String country;
    private String region;
    private String city;

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "country:" + country + " region: " + region + " city: " + city;

    }
}
