package com.example.basketballteam.service;

import com.example.basketballteam.model.Manager;

import java.util.List;

public interface ManagerService {
    Manager selectById(int id);
    Manager selectByPassword(int id,String password);
    List<Manager> getManagersWithPowerZero(int managerPower);
    int updateManager(Manager manager);
    int power(int id);
    int addManager(Manager manager);
}
