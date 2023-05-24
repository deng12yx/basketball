package com.example.basketballteam.service;

import com.example.basketballteam.model.Schedule;

import java.util.List;

public interface ScheduleService {
    int addHappenedSchedule(Schedule schedule);//增加
    int addHappeningSchedule(Schedule schedule);
    Schedule findScheduleById(int id);
    int deleteScheduleById(int id);//删除
    List<Schedule> findAllSchedules();//查询所有
    int updateSchedule(Schedule schedule);//根据id更新
    int countAllSchedules();//查询记录个数
    List<Schedule> findSchedulesByPage(int offset);
    List<Schedule> findSchedulesFive();
}
