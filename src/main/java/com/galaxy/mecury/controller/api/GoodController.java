package com.galaxy.mecury.controller.api;

import com.galaxy.mecury.entity.Good;
import com.galaxy.mecury.service.GoodService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {
    @Resource
    private GoodService goodService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public List<String> add(@RequestBody Good good) {
        List<String> users = new ArrayList<>();
        users.add("peter");
        users.add("david");
        users.add("王小彬");
        goodService.insertSelective(good);
        return users;
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public Good selectById(@PathVariable("id") Integer id) {
        return goodService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody Good good) {
        goodService.updateByPrimaryKeySelective(good);
        return "success";
    }
}
