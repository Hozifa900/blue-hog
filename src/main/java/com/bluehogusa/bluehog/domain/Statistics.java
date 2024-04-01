package com.bluehogusa.bluehog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistics extends IPInfo {
    private Long id;
    private String action;

}
