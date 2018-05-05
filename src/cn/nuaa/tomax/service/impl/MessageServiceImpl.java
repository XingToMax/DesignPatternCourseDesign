package cn.nuaa.tomax.service.impl;

import cn.nuaa.tomax.dao.IMessageDao;
import cn.nuaa.tomax.entity.MessageEntity;
import cn.nuaa.tomax.entity.ResultCause;
import cn.nuaa.tomax.service.IMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/5 18:42
 */
@Service
public class MessageServiceImpl implements IMessageService{
    @Resource
    private IMessageDao messageDao;
    @Override
    public ResultCause addMessage(MessageEntity msg) {
        msg.setTime(new Timestamp(System.currentTimeMillis()));
        String sql = "insert into message (user_id,content,time) values (:userId,:content,:time)";
        messageDao.saveMessage(sql,msg);
        return new ResultCause(ResultCause.SUCCESS_CODE,"添加消息成功");
    }

    @Override
    public List<MessageEntity> getMsgs() {
        String sql = "select m.id,m.user_id,m.content,m.time,u.name from message as m inner join user as u on (m.user_id = u.id) order by m.time desc";
        return messageDao.listMsgs(sql,new Object[]{});
    }
}
