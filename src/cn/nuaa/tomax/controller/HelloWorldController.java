package cn.nuaa.tomax.controller;

import cn.nuaa.tomax.entity.FormEntity;
import cn.nuaa.tomax.entity.GoodEntity;
import cn.nuaa.tomax.entity.ResultCause;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/4/5 23:34
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {
    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String sayHello() {
        return "index";
    }

    @RequestMapping(value = "/getGoodList",method = RequestMethod.GET)
    public @ResponseBody List<GoodEntity> getGoodList(){
        List<GoodEntity> goodEntities = new ArrayList<>();
        goodEntities.add(new GoodEntity(1,"iphone",5000));
        goodEntities.add(new GoodEntity(2,"ipad",4000));
        goodEntities.add(new GoodEntity(3,"macpro",120000));
        return goodEntities;
    }

    @RequestMapping(value = "/checkToken", method = RequestMethod.GET)
    public @ResponseBody
    ResultCause checkToken(String token){
        if (token.equals("1")){
            return new ResultCause(ResultCause.SUCCESS_CODE,"验证成功");
        }else {
            return new ResultCause(ResultCause.FAIL_CODE,"验证失败");
        }
    }

//    /**
//     * 表单输入值依次映射到参数上
//     * @param name
//     * @param signature
//     * @return
//     */
//    @RequestMapping(value = "/form",method = {RequestMethod.GET,RequestMethod.POST})
//    public @ResponseBody
//    ResultCause testForm(String name, String signature){
//        System.out.println(name+"'s is : "+signature);
//        return new ResultCause("200",name+"'s is : "+signature);
//    }

    /**
     * 表单输入映射到对象上
     * @param form
     * @return
     */
    @RequestMapping(value = "/form",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    ResultCause testForm(FormEntity form){
        System.out.println(form.getName()+"'s is : "+form.getSignature());
        return new ResultCause("200",form.getName()+"'s is : "+form.getSignature());
    }

    @RequestMapping(value = "ajax_test", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    ResultCause testAjax(FormEntity form){
        System.out.println(form.getName()+"'s is : "+form.getSignature());
        return new ResultCause("200",form.getName()+"'s is : "+form.getSignature());
    }

    @RequestMapping(value = "get_list", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    List<ResultCause> getList(){
        List<ResultCause> resultCauses = new ArrayList<>();
        resultCauses.add(new ResultCause("200","汤茂行"));
        resultCauses.add(new ResultCause("300","Java"));
        resultCauses.add(new ResultCause("400","Hello World"));
        return resultCauses;
    }
}
