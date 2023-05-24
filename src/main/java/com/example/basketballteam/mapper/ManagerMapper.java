package com.example.basketballteam.mapper;

import com.example.basketballteam.model.Manager;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ManagerMapper {
    @Select("select * from cyberspacesecuritybasketballteam.manager " +
            "where managerId=#{0} and managerPassword=#{1} ")
    Manager selectByPassword(int id,String password);
    @Select("select * from cyberspacesecuritybasketballteam.manager " +
            "where managerId=#{id}")
    Manager selectById(int id);
    @Select("select managerPower from cyberspacesecuritybasketballteam.manager where managerId=#{id}")
    int power(int id);
    @Insert("INSERT INTO cyberspacesecuritybasketballteam.manager (managerPassword, managerName, managerTel, managerPower,managerImage) " +
            "VALUES (#{managerPassword}, #{managerName}, #{managerTel}, #{managerPower},#{managerImage})")
    @Options(useGeneratedKeys = true, keyProperty = "managerId", keyColumn = "managerId")
    int addManager(Manager manager);
    @Select("SELECT * FROM cyberspacesecuritybasketballteam.manager WHERE managerPower = #{managerPower}")
    List<Manager> getManagersWithPowerZero(int managerPower);

    @Update("UPDATE cyberspacesecuritybasketballteam.manager SET managerPassword = #{managerPassword}, managerName = #{managerName}, managerTel = #{managerTel}, managerPower = #{managerPower} WHERE managerId = #{managerId}")
    int updateManager(Manager manager);

}
