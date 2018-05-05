package cn.nuaa.tomax.controller;

import cn.nuaa.tomax.entity.ResultCause;
import cn.nuaa.tomax.entity.UserEntity;
import cn.nuaa.tomax.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/4 23:41
 */
@Controller
@RequestMapping("/user")
public class UserController extends SuperAction{
    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    ResultCause login(String name, String password) throws IOException {
        ResultCause result = userService.checkUser(name,password);
        if (result.getCode().equals(ResultCause.SUCCESS_CODE)){
            //TODO : 处理session
        }
        return result;
    }

    @RequestMapping(value = "/register", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    ResultCause register(UserEntity user){
        return userService.registerUser(user);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void test() throws IOException {
        response.addCookie(new Cookie("nasss","nasss"));
        response.getWriter().print(new ResultCause("200","sadfas"));
    }
}
