package com.example.basketballteam.config;

import com.example.basketballteam.model.Manager;
import com.example.basketballteam.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.concurrent.SubjectAwareExecutor;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm{

    @Autowired
    private ManagerService managerService;
    /**
     * 授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        System.out.println("执行授权逻辑");
        Subject subject= SecurityUtils.getSubject();
        Manager manager=(Manager) subject.getPrincipal();
//        Set<String> set=new HashSet<>();
//        set.add(String.valueOf(manager.getManagerPower()));

        //给资源进行授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        info.addStringPermission(String.valueOf(manager.getManagerPower()));

        return info;
    }

    /**
     * 认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) arg0;
        Manager manager=managerService.selectByPassword(Integer.parseInt(token.getUsername()), String.valueOf(token.getPassword()));

        if(manager==null){
            return null;
        }
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("manager", manager);
//        System.out.println("执行认证逻辑");
//        return null;
        return new SimpleAuthenticationInfo(manager,manager.getManagerPassword(),"");
    }

}