package cn.nuaa.tomax.dao;

import cn.nuaa.tomax.entity.UserEntity;

import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/4 22:25
 */
public interface IUserDao {
    /**
     * 新增用户
     * @param sql
     * @param user
     */
    public void saveUser(String sql, UserEntity user);

    /**
     * 根据条件获取用户列表
     * @param sql
     * @param keys
     * @return
     */
    public List<UserEntity> listUsers(String sql, Object[] keys);
}
