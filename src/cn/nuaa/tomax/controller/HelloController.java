package cn.nuaa.tomax.controller;

import cn.nuaa.tomax.entity.HelloEntity;
import cn.nuaa.tomax.entity.ResultCause;
import cn.nuaa.tomax.service.IHelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/1 19:58
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Resource
    private IHelloService helloService;

    @RequestMapping(value = "/addHello", method = RequestMethod.GET)
    public @ResponseBody
    ResultCause addHelloData(HelloEntity hello){
        return helloService.addHello(hello);
    }

    @RequestMapping(value = "/getHelloList", method = RequestMethod.GET)
    public @ResponseBody
    List<HelloEntity> getHelloList(){
        return helloService.listHello();
    }

    @RequestMapping(value = "/updateHello", method = RequestMethod.GET)
    public @ResponseBody
    ResultCause updateHello(HelloEntity hello){
        return helloService.updateHelloData(hello);
    }

    @RequestMapping(value = "/deleteHello", method = RequestMethod.GET)
    public @ResponseBody
    ResultCause deleteHelloData(String name){
        return helloService.removeHelloData(name);
    }

}
