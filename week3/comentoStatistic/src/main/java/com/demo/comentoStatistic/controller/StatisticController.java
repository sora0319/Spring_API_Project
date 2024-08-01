package com.demo.comentoStatistic.controller;

import com.demo.comentoStatistic.dto.YearCountDto;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StatisticController {

    @Autowired
    StatisticService statisticService;

    // 연도별 접속자 수
    @RequestMapping(value="/api/v1/logins/calender/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year){

        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    // 연도별 월별 접속자 수
    @RequestMapping(value="/api/v1/logins/calender/{year}/{month}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthLoginCount(@PathVariable("year") String year, @PathVariable("month") String month){

        return ResponseEntity.ok(statisticService.getYearMonthLogins(year, month));
    }

    //  월별 접속자 수
    @RequestMapping(value="/api/v1/logins/totalmonth/{month}", produces = "application/json")
    @ResponseBody
    public Object getMonthLoginCount(@PathVariable("month") int month){

        return ResponseEntity.ok(statisticService.getMonthLogins(month));
    }
    // 일자별 접속자 수
    @RequestMapping(value="/api/v1/logins/totaldate/{date}", produces = "application/json")
    @ResponseBody
    public Object getDateLoginCount(@PathVariable("date") int date){

        return ResponseEntity.ok(statisticService.getDateLogins(date));
    }
    // 평균 하루 로그인 수
    @RequestMapping(value="/api/v1/logins/totaldate/average", produces = "application/json")
    @ResponseBody
    public Object getDateAverageLoginCount(){

        return ResponseEntity.ok(statisticService.getDateAverageLogins());
    }
    // 부서별 월별 로그인 수
    @RequestMapping(value="/api/v1/logins/department/{organ}/{month}", produces = "application/json")
    @ResponseBody
    public Object getOrganLoginMonthCount(@PathVariable("organ") String organ, @PathVariable("month") String month){
        Map<String, Object> params = new HashMap<>();
        params.put("organ", organ);
        params.put("month", month);
        return ResponseEntity.ok(statisticService.getOrganMonthLogins(params));
    }
    // 휴일을 제외한 로그인 수
    @RequestMapping(value="/api/v1/logins/weekday", produces = "application/json")
    @ResponseBody
    public Object getWeekdayLoginCount(){

        return ResponseEntity.ok(statisticService.getWeekdayLogins());
    }
}