package com.example.basketballteam.controller;

import com.example.basketballteam.model.BaseResult;
import com.example.basketballteam.model.Schedule;
import com.example.basketballteam.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/schedule/addSchedule")
    public String addSchedule() {
        return "addNewSchedule";
    }
    @RequestMapping("/schedule/updateSchedule={scheduleId}")
    public String updateSchedule(@PathVariable("scheduleId") int scheduleId, ModelMap map){
        Schedule schedule=scheduleService.findScheduleById(scheduleId);
        if (schedule.getScheduleResult()!=1||schedule.getScheduleResult()!=0){
            map.addAttribute("scheduleState",1);
        }else{
            map.addAttribute("scheduleState",0);
        }
        map.addAttribute("schedule",schedule);
        return "updateSchedule";
    }

    @RequestMapping(value = "/updateNewScheduleIn", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult updateNewIn(String scheduleTime, String scheduleRival, String scheduleState, int scheduleResult, String scheduleScore) {
//        int results;
        BaseResult result = new BaseResult();
        Schedule schedule = new Schedule();
//        if (scheduleResult.equals("win")){
//            results=1;
//        }else{
//            results=0;
//        }
        schedule.setScheduleResult(scheduleResult);
        schedule.setScheduleRival(scheduleRival);
        schedule.setScheduleScore(scheduleScore);
        schedule.setScheduleTime(scheduleTime);
        if (scheduleState.equals("upcoming")) {
            result.setCode(scheduleService.addHappeningSchedule(schedule));
        } else {
            result.setCode(scheduleService.addHappenedSchedule(schedule));
        }
        if (result.getCode() == 1) {
            result.setMsg("success");
        } else {
            result.setMsg("error");
        }
        return result;
    }

    @RequestMapping(value = "/addScheduleIn", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult updateIn(int scheduleId, String scheduleTime, String scheduleRival, int scheduleResult, String scheduleScore) {
        BaseResult result = new BaseResult();
        Schedule schedule = new Schedule(scheduleId, scheduleTime, scheduleRival, scheduleResult, scheduleScore);
        result.setCode(scheduleService.updateSchedule(schedule));
        return result;
    }

}
