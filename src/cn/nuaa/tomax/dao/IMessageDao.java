package cn.nuaa.tomax.dao;

import cn.nuaa.tomax.entity.MessageEntity;

import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/5 18:37
 */
public interface IMessageDao {
    /**
     * 新增留言
     * @param sql
     * @param message
     */
    public void saveMessage(String sql, MessageEntity message);

    /**
     * 获取留言
     * @param sql
     * @param keys
     * @return
     */
    public List listMsgs(String sql, Object[] keys);
}
