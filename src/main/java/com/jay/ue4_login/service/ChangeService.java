package com.jay.ue4_login.service;

import com.jay.ue4_login.dao.UeUserMapper;
import com.jay.ue4_login.entity.UeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChangeService {

    @Autowired
    UeUserMapper ueUserMapper;

    public Map change(UeUser ueUser) {

        Map map1 = new HashMap();
        ueUser.setPassword(ueUser.getPassword() == null ? null : DigestUtils.md5DigestAsHex(ueUser.getPassword().toUpperCase().getBytes()));
        try {
            int i = ueUserMapper.updateByAccountSelective(ueUser);
            if (i > 0) {
                map1.put("success", "success");
            } else {
                map1.put("success", "fail");
            }
        } catch (Exception e) {
            map1.put("success", "fail");
            e.getStackTrace();
        }

        Map map = new HashMap();
        map.put("result", map1);
        return map;
    }
}
