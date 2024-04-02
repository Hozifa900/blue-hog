package com.bluehogusa.bluehog.domain;

import lombok.Data;

@Data
public class IPInfo {
    private String id;
    private String ip;
    private String country;
    private String region;
    private String city;

}