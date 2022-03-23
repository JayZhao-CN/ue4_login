package com.jay.ue4_login.controller;

import com.jay.ue4_login.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public Map register(@RequestParam("username")String username,
                        @RequestParam("password")String password){
        Map map = registerService.addUser(username, password);
        return map;
    }
}
