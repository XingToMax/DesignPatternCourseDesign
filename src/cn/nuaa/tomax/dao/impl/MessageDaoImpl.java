package cn.nuaa.tomax.dao.impl;

import cn.nuaa.tomax.dao.DaoHelper;
import cn.nuaa.tomax.dao.IMessageDao;
import cn.nuaa.tomax.entity.MessageEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/5 18:39
 */
@Repository
public class MessageDaoImpl extends DaoHelper implements IMessageDao{
    @Override
    public void saveMessage(String sql, MessageEntity message) {
        this.insertByBean(sql,message);
    }

    @Override
    public List<MessageEntity> listMsgs(String sql, Object[] keys) {
        return this.query(sql,keys,MessageEntity.class);
    }
}
