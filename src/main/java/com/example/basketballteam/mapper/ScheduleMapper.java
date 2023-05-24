package com.example.basketballteam.mapper;

import com.example.basketballteam.model.Article;
import com.example.basketballteam.model.Player;
import com.example.basketballteam.model.Schedule;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ScheduleMapper {
    @Insert("INSERT INTO cyberspacesecuritybasketballteam.schedule " +
            "(scheduleTime, scheduleRival, scheduleResult, scheduleScore) " +
            "VALUES " +
            "(#{scheduleTime, jdbcType=TIMESTAMP}, #{scheduleRival}, #{scheduleResult}, #{scheduleScore})")
    @Options(useGeneratedKeys = true, keyProperty = "scheduleId", keyColumn = "scheduleId")
    int addHappenedSchedule(Schedule schedule);
    @Insert("INSERT INTO cyberspacesecuritybasketballteam.schedule " +
            "(scheduleTime, scheduleRival) " +
            "VALUES " +
            "(#{scheduleTime, jdbcType=TIMESTAMP}, #{scheduleRival})")
    @Options(useGeneratedKeys = true, keyProperty = "scheduleId", keyColumn = "scheduleId")
    int addHappeningSchedule(Schedule schedule);
    @Select("select * from cyberspacesecuritybasketballteam.schedule where scheduleId=#{id}")
    Schedule findScheduleById(int id);
    @Delete("DELETE FROM cyberspacesecuritybasketballteam.schedule WHERE scheduleId = #{id}")
    int deleteScheduleById(int id);//删除
    @Select("SELECT * FROM cyberspacesecuritybasketballteam.schedule")
    List<Schedule> findAllSchedules();//查询所有
    @Update("UPDATE cyberspacesecuritybasketballteam.schedule SET scheduleTime=#{scheduleTime, jdbcType=TIMESTAMP}, " +
            "scheduleRival=#{scheduleRival}, scheduleResult=#{scheduleResult}, " +
            "scheduleScore=#{scheduleScore} WHERE scheduleId=#{scheduleId}")
    int updateSchedule(Schedule schedule);//根据id更新
    @Select("SELECT COUNT(*) FROM cyberspacesecuritybasketballteam.schedule")
    int countAllSchedules();//查询记录个数
    @Select("SELECT * FROM cyberspacesecuritybasketballteam.schedule ORDER BY scheduleTime DESC LIMIT 15 OFFSET #{offset}")
    List<Schedule> findSchedulesByPage(int offset);
    @Select("SELECT * FROM cyberspacesecuritybasketballteam.schedule ORDER BY scheduleTime DESC LIMIT 5")
    List<Schedule> findSchedulesFive();



}
