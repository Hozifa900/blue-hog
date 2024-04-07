package com.bluehogusa.bluehog.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    public ResponseEntity<?> getStatistics(HttpServletRequest request, @RequestBody String action) {
        try {

            String userIP = request.getRemoteAddr();
            String apiUrl = "https://ipapi.co/69.18.37.194/json/";

            RestTemplate restTemplate = new RestTemplate();
            System.out.println("testing");
            IPInfo ipInfo = restTemplate.getForObject(apiUrl, IPInfo.class);

            Statistics statistics = new Statistics();
            statistics.setCity(ipInfo.getCity());
            statistics.setCountry(ipInfo.getCountry());
            statistics.setRegion(ipInfo.getRegion());
            statistics.setAction(action);
            statistics.setIp(userIP);
            statisticsService.saveStatistics(statistics);
            // Use ipInfo as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Statistics> statisticsList = statisticsService.getAllStatistics();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Statistics saved successfully");
        response.put("status", Response.SC_OK);
        response.put("data", statisticsList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
