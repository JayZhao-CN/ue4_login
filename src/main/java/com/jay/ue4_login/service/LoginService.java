package com.jay.ue4_login.service;

import com.jay.ue4_login.dao.UeUserMapper;
import com.jay.ue4_login.entity.UeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    UeUserMapper ueUserMapper;

    public Map getUser(String account,String password){

        UeUser ueUser = ueUserMapper.selectByAccount(account);

        Map map = new HashMap();
        if (ueUser != null) {

            if (ueUser.getPassword().equals(password)) {
                // 密码正确
                Map map1 = new HashMap();
                map1.put("isLogin", "success");
                Map map2 = new HashMap();
                map2.put("username", ueUser.getUsername());
                map2.put("level", ueUser.getLevel());
                map1.put("userInfo", map2);
                map.put("result", map1);
            } else {
                // 密码错误
                Map map1 = new HashMap();
                map1.put("isLogin", "fail");
                map.put("result", map1);
            }
        }else {
            // 密码错误
            Map map1 = new HashMap();
            map1.put("isLogin", "fail");
            map.put("result", map1);
        }
        return map;

    }
}
