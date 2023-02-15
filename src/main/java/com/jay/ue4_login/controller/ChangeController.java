package com.jay.ue4_login.controller;

import com.jay.ue4_login.entity.UeUser;
import com.jay.ue4_login.service.ChangeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChangeController {

    @Autowired
    ChangeService changeService;

    @PostMapping("/change")
    @ApiOperation("修改")
    public Map change(UeUser ueUser){
        Map change = changeService.change(ueUser);
        return change;
    }
}
