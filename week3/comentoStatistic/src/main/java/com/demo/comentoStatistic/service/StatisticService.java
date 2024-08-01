package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.StatisticMapper;
import com.demo.comentoStatistic.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StatisticService {


    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){

        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){

        return statisticMapper.selectYearMonthLogin(year+month);
    }

    public MonthCountDto getMonthLogins(int month){

        return statisticMapper.selectMonthLogin(month);
    }

    public DateCountDto getDateLogins(int date){

        return statisticMapper.selectDateLogin(date);
    }

    public DateAverageDto getDateAverageLogins(){

        return statisticMapper.selectDateAverageLogin();
    }

    public OrganMonthDto getOrganMonthLogins(Map<String, Object> params){

        return statisticMapper.selectOrganMonthLogin(params);
    }

    public WeekdayCountDto getWeekdayLogins(){

        return statisticMapper.selectWeekdayLogin();
    }

}