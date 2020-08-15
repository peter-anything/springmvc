package com.galaxy.mecury.controller.api;

import com.galaxy.mecury.annotation.Auth;
import com.galaxy.mecury.entity.User;
import com.galaxy.mecury.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Auth
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public List<String> add(@RequestBody User user) {
        List<String> users = new ArrayList<>();
        users.add("peter");
        users.add("david");
        users.add("王小彬");
        userService.insertSelective(user);
        return users;
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public User selectById(@PathVariable("id") Integer id) {
        return userService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody User user) {
        userService.updateByPrimaryKeySelective(user);
        return "success";
    }
}
