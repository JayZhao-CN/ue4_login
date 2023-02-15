package com.jay.ue4_login.controller;

import com.jay.ue4_login.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public Map ueLogin(@RequestParam("account")String account,
                       @RequestParam("password")String password){
        Map result = loginService.getUser(account, password);
        return result;
    }
}
