package com.jay.ue4_login.service;

import com.jay.ue4_login.dao.UeUserMapper;
import com.jay.ue4_login.entity.UeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterService {

    @Autowired
    UeUserMapper ueUserMapper;

    public Map addUser(String username, String password) {

        UeUser ueUser1 = new UeUser();

        long l = System.currentTimeMillis();

        ueUser1.setAccount(String.valueOf(l));
        ueUser1.setUsername(username);
        ueUser1.setPassword(password);

        Map map1 = new HashMap();

        try {
            int i = ueUserMapper.insertSelective(ueUser1);
            if (i == 1) {
                map1.put("success", "success");
                map1.put("msg",String.valueOf(l));
            } else {
                map1.put("success", "fail");
                map1.put("msg","注册失败");
            }
        } catch (Exception e) {
            map1.put("success", "fail");
            map1.put("msg","注册失败");
            e.getStackTrace();
        }

        Map map = new HashMap();
        map.put("result", map1);

        return map;

    }
}
