package com.galaxy.mecury.controller.api;

import com.galaxy.mecury.annotation.Auth;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NBAPlayerController {

    @Auth(permission = "admin")
    @RequestMapping("/users")
    public List<String> list() {
        List<String> users = new ArrayList<>();
        users.add("peter");
        users.add("david");
        users.add("王小彬");
        return users;
    }
}
