package cn.nuaa.tomax.service;

import cn.nuaa.tomax.entity.MessageEntity;
import cn.nuaa.tomax.entity.ResultCause;

import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/5 18:41
 */
public interface IMessageService {
    public ResultCause addMessage(MessageEntity msg);
    public List<MessageEntity> getMsgs();
}
