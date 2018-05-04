package cn.nuaa.tomax.dao.impl;

import cn.nuaa.tomax.dao.DaoHelper;
import cn.nuaa.tomax.dao.IUserDao;
import cn.nuaa.tomax.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/4 22:29
 */
@Repository
public class UserDaoImpl extends DaoHelper implements IUserDao{
    @Override
    public void saveUser(String sql, UserEntity user) {
        this.insertByBean(sql,user);
    }

    @Override
    public List<UserEntity> listUsers(String sql, Object[] keys) {
        return this.query(sql,keys,UserEntity.class);
    }
}
