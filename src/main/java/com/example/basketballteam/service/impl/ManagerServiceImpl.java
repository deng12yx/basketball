package com.example.basketballteam.service.impl;

import com.example.basketballteam.mapper.ManagerMapper;
import com.example.basketballteam.model.Manager;
import com.example.basketballteam.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public Manager selectById(int id) {
        return this.managerMapper.selectById(id);
    }

    @Override
    public Manager selectByPassword(int id, String password) {
        return this.managerMapper.selectByPassword(id, password);
    }

    @Override
    public List<Manager> getManagersWithPowerZero(int managerPower) {
        return this.managerMapper.getManagersWithPowerZero(managerPower);
    }

    @Override
    public int updateManager(Manager manager) {
        return this.managerMapper.updateManager(manager);
    }

    @Override
    public int power(int id) {
        return this.managerMapper.power(id);
    }

    @Override
    public int addManager(Manager manager) {
        return this.managerMapper.addManager(manager);
    }
}
