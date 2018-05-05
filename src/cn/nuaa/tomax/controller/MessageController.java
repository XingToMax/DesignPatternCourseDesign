package cn.nuaa.tomax.controller;

import cn.nuaa.tomax.entity.MessageEntity;
import cn.nuaa.tomax.entity.ResultCause;
import cn.nuaa.tomax.service.IMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/5 18:55
 */
@Controller
@RequestMapping("/msg")
public class MessageController {
    @Resource
    private IMessageService messageService;

    @RequestMapping(value = "/addMsg", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    ResultCause addMsg(MessageEntity msg){
        return messageService.addMessage(msg);
    }

    @RequestMapping(value = "/getMsgs", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    List<MessageEntity> getMsgs(){
        return messageService.getMsgs();
    }
}
