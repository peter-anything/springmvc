package com.galaxy.mecury.controller.api;

import com.galaxy.mecury.entity.Good;
import com.galaxy.mecury.entity.Mechant;
import com.galaxy.mecury.service.GoodService;
import com.galaxy.mecury.service.MechantService;
import com.galaxy.mecury.service.OrderService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MechantController {
    @Resource
    private MechantService mechantService;

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public List<String> add(@RequestBody Mechant mechant) {
        List<String> users = new ArrayList<>();
        users.add("peter");
        users.add("david");
        users.add("王小彬");
        mechantService.insertSelective(mechant);
        return users;
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public Mechant selectById(@PathVariable("id") Integer id) {
        return mechantService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody Mechant mechant) {
        mechantService.updateByPrimaryKeySelective(mechant);
        return "success";
    }
}
