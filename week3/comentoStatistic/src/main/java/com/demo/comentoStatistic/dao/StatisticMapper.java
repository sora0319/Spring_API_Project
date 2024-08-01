package com.demo.comentoStatistic.dao;

import com.demo.comentoStatistic.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(String yearMonth);

    MonthCountDto selectMonthLogin(int month);
    DateCountDto selectDateLogin(int date);
    DateAverageDto selectDateAverageLogin();
    OrganMonthDto selectOrganMonthLogin(Map<String, Object> params);
    WeekdayCountDto selectWeekdayLogin();
}
