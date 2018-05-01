package cn.nuaa.tomax.dao;

import cn.nuaa.tomax.entity.HelloEntity;

import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/4/30 23:14
 */
public interface IHelloDao {
    /**
     * 保存单个HelloEntity对象
     * @param sql 保存sql语句
     * @param bean HelloEntity对象
     */
    public void saveHello(String sql, HelloEntity bean);

    /**
     * 查询满足一定条件的hello列表
     * @param sql 查询sql语句
     * @param keys 查询中需要用的约束值数组
     * @return
     */
    public List<HelloEntity> listHello(String sql, Object[] keys);

    /**
     * 更新满足一定条件的hello数据
     * @param sql
     * @param keys
     */
    public void updateHelloData(String sql, Object[] keys);

    /**
     * 删除满足一定条件的hello数据
     * @param sql
     * @param keys
     */
    public void removeHelloData(String sql, Object[] keys);

}
