package cn.nuaa.tomax.service;

import cn.nuaa.tomax.entity.HelloEntity;
import cn.nuaa.tomax.entity.ResultCause;

import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/4/30 23:59
 */
public interface IHelloService {
    /**
     * 增加hello数据
     * @param bean
     * @return
     */
    public ResultCause addHello(HelloEntity bean);

    /**
     * 获取hello数据
     * @return
     */
    public List<HelloEntity> listHello();

    /**
     * 更新hello数据，更新对应name的signature
     * @param bean
     * @return
     */

    public ResultCause updateHelloData(HelloEntity bean);

    /**
     * 删除指定name的hello数据
     * @param name
     * @return
     */
    public ResultCause removeHelloData(String name);
}
