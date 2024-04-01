package com.bluehogusa.bluehog.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bluehogusa.bluehog.domain.IPInfo;
import com.bluehogusa.bluehog.domain.Statistics;
import com.bluehogusa.bluehog.services.IpInfoService;
import com.bluehogusa.bluehog.services.StatisticsService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/statistics")
@CrossOrigin(origins = "*")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;
    @Autowired
    private IpInfoService ipInfoService;
    @GetMapping("")
    public ResponseEntity<?> getStatistics(HttpServletRequest request) {
         try {
            String userIP = request.getRemoteAddr();
            IPInfo ipInfo = ipInfoService.getIpInfo(userIP).get();
            System.out.println(ipInfo);
            // Use ipInfo as needed
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Internal server error");
        }
        List<Statistics> statisticsList = statisticsService.getAllStatistics();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Statistics fetched successfully");
        response.put("status", Response.SC_OK);
        response.put("data", statisticsList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
