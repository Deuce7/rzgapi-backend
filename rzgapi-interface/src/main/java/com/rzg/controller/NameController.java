package com.rzg.controller;


import com.rzg.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 *  名字 API
 * @author Deuce7
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name) {
        return "Get 用户名是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 用户名是" + name;
    }

    @PostMapping("/user")
    public String getNameByPost(@RequestBody User user, HttpServletRequest request) {

        return "POST 用户名是" + user.getUsername();
    }
}
