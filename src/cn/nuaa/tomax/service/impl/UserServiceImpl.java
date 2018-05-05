package cn.nuaa.tomax.service.impl;

import cn.nuaa.tomax.dao.IUserDao;
import cn.nuaa.tomax.entity.ResultCause;
import cn.nuaa.tomax.entity.UserEntity;
import cn.nuaa.tomax.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;


/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/4 22:48
 */
@Service
public class UserServiceImpl implements IUserService{
    @Resource
    private IUserDao userDao;

    @Override
    public ResultCause checkUser(String name, String password) {
        UserEntity user = getTargetUser(name);
        if (user == null){
            //未查到该用户，即用户不存在
            return new ResultCause(ResultCause.FAIL_CODE,"用户名或密码错误");
        }else if (user.getPassword().equals(password)){
            //登录验证成功
            return new ResultCause(ResultCause.SUCCESS_CODE,"登录成功");
        }
        //密码错误
        return new ResultCause(ResultCause.FAIL_CODE,"用户名或密码错误");
    }

    @Override
    public ResultCause registerUser(UserEntity user) {
        if (getTargetUser(user.getName()) != null){
            return new ResultCause(ResultCause.FAIL_CODE,"用户名已存在");
        }else {
            //设置注册时间
            user.setTime(new Timestamp(System.currentTimeMillis()));
            //id为自增字段，所以不需要在这里设置
            String sql = "insert into user (name,password,time) values (:name,:password,:time)";
            userDao.saveUser(sql,user);
        }
        return new ResultCause(ResultCause.SUCCESS_CODE,"注册成功");
    }

    @Override
    public UserEntity getUserInfo(String name) {
        String sql = "select name,id from user where name = ?";
        return userDao.listUsers(sql,new Object[]{name}).get(0);
    }

    /**
     * 根据用户名查找用户，因为本系统用户名唯一，所以用户名查找到的结果为单个用户对象
     * 同时，因为在登录验证和注册查重中均有查询用户对象的需求，所以将这部分代码拿出，
     * 进行复用
     * @param name
     * @return 如果查询结果非空，返回唯一的结果，否则返回空值
     */
    private UserEntity getTargetUser(String name){
        String sql = "select * from user where name = ?";
        List<UserEntity> userEntities = userDao.listUsers(sql,new Object[]{name});
        return (userEntities!=null&&userEntities.size()>0)?userEntities.get(0):null;
    }
}
