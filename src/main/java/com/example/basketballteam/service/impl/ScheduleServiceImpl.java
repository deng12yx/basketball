package com.example.basketballteam.service.impl;

import com.example.basketballteam.mapper.ScheduleMapper;
import com.example.basketballteam.model.Schedule;
import com.example.basketballteam.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleMapper scheduleMapper;


    @Override
    public int addHappenedSchedule(Schedule schedule) {
        return this.scheduleMapper.addHappenedSchedule(schedule);
    }

    @Override
    public int addHappeningSchedule(Schedule schedule) {
        return this.scheduleMapper.addHappeningSchedule(schedule);
    }

    @Override
    public Schedule findScheduleById(int id) {
        return this.scheduleMapper.findScheduleById(id);
    }

    @Override
    public int deleteScheduleById(int id) {

        return this.scheduleMapper.deleteScheduleById(id);
    }

    @Override
    public List<Schedule> findAllSchedules() {
        return this.scheduleMapper.findAllSchedules();
    }

    @Override
    public int updateSchedule(Schedule schedule) {
        return this.scheduleMapper.updateSchedule(schedule);
    }

    @Override
    public int countAllSchedules() {
        return this.scheduleMapper.countAllSchedules();
    }

    @Override
    public List<Schedule> findSchedulesByPage(int offset) {
        return this.scheduleMapper.findSchedulesByPage(offset);
    }

    @Override
    public List<Schedule> findSchedulesFive() {
        return this.scheduleMapper.findSchedulesFive();
    }
}
