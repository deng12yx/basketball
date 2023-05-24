package com.example.basketballteam.controller;

import com.example.basketballteam.model.Manager;
import com.example.basketballteam.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class managerController {
    @Autowired
    ManagerService managerService;

    @RequestMapping("/manager/addManager")
    public String addManager() {
        return "addNewManager";
    }

    @RequestMapping("/manager/updateManager={managerId}")
    public String updateManager(@RequestParam("managerId") int managerId, ModelMap map) {
        Manager manager = managerService.selectById(managerId);
        map.addAttribute("manager", manager);
        return "updateManager";
    }

    @RequestMapping(value = "/updateManager", method = RequestMethod.POST)
    public String updateManager2(@RequestParam("managerName") String managerName,
                                 @RequestParam("managerId") int managerId,
                                 @RequestParam("password") String managerPassword,
                                 @RequestParam("phoneNumber") String managerTel) {
        Manager managerInit=managerService.selectById(managerId);

        Manager manager = new Manager(managerId, managerPassword, managerName, managerTel, 0,managerInit.getManagerImage());
        if (managerService.updateManager(manager) == 1) {
            return "redirect:/manager";
        } else {
            return "redirect:/manager/addManager";
        }
    }

    @RequestMapping("/manager")
    public String manager(ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getSession().getAttribute("manager");
        if (manager != null) {
            map.addAttribute("managerAll", manager);

        } else {
        }
        List<Manager> managersWithPowerZero = managerService.getManagersWithPowerZero(0);
        map.addAttribute("managers", managersWithPowerZero);
        return "manager";
    }

    @RequestMapping(value = "/addManager", method = RequestMethod.POST)
    public String addManager2(@RequestParam("managerName") String managerName,
                              @RequestParam("password") String managerPassword,
                              @RequestParam("phoneNumber") String managerTel,
                              @RequestParam("Photo") MultipartFile photoUrl) {
        String savePath = "D:\\开摆\\数据库\\basketballTeam\\src\\main\\resources\\static\\image";
        Manager manager = new Manager();
        if (photoUrl != null && !photoUrl.isEmpty()) {
            try {
                // 生成唯一的文件名
                String originalFilename = photoUrl.getOriginalFilename();
                String extension = StringUtils.getFilenameExtension(originalFilename);
                String fileName = System.currentTimeMillis() + "." + extension;
                // 拼接文件保存的完整路径
                savePath = savePath + File.separator + fileName;
                // 保存图片文件到服务器
                File saveFile = new File(savePath);
                photoUrl.transferTo(saveFile);
                String SelfieImage = "/static/image/" + fileName;
                manager.setManagerImage(SelfieImage);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        int power = 0;
        manager.setManagerName(managerName);
        manager.setManagerPassword(managerPassword);
        manager.setManagerTel(managerTel);
        manager.setManagerPower(power);

        if (managerService.addManager(manager) == 1) {
            return "redirect:/manager";
        } else {
            return "redirect:/manager/addManager";
        }

    }

}
