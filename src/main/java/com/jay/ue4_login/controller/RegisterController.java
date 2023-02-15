package com.jay.ue4_login.controller;

import com.jay.ue4_login.service.RegisterService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("注册")
    public Map register(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        @RequestParam("email")String email){
        Map map = registerService.addUser(username, password, email);
        return map;
    }
}
