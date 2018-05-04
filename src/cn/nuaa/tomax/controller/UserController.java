package cn.nuaa.tomax.controller;

import cn.nuaa.tomax.entity.ResultCause;
import cn.nuaa.tomax.entity.UserEntity;
import cn.nuaa.tomax.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/4 23:41
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    ResultCause login(String name, String password){
        return userService.checkUser(name,password);
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    ResultCause register(UserEntity user){
        return userService.registerUser(user);
    }
}
