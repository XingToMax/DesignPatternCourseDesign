package cn.nuaa.tomax.service;

import cn.nuaa.tomax.entity.ResultCause;
import cn.nuaa.tomax.entity.UserEntity;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/4 22:44
 */
public interface IUserService {
    /**
     * 登录验证
     * @param name
     * @param password
     * @return
     */
    public ResultCause checkUser(String name, String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    public ResultCause registerUser(UserEntity user);
}
