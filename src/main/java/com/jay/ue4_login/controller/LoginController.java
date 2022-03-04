package com.jay.ue4_login.controller;

import com.jay.ue4_login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public Map ueLogin(@RequestParam("account")String account,
                       @RequestParam("password")String password){
        Map result = loginService.getUser(account, password);
        return result;
    }
}
