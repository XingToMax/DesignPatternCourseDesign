package cn.nuaa.tomax.dao.impl;

import cn.nuaa.tomax.dao.DaoHelper;
import cn.nuaa.tomax.dao.IHelloDao;
import cn.nuaa.tomax.entity.HelloEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/4/30 23:25
 */
@Repository
public class HelloDaoImpl extends DaoHelper implements IHelloDao {
    @Override
    public void saveHello(String sql, HelloEntity bean) {
        this.insertByBean(sql,bean);
    }

    @Override
    public List<HelloEntity> listHello(String sql, Object[] keys) {
        return this.query(sql,keys,HelloEntity.class);
    }

    @Override
    public void updateHelloData(String sql, Object[] keys) {
        this.update(sql,keys);
    }

    @Override
    public void removeHelloData(String sql, Object[] keys) {
        this.update(sql,keys);
    }
}
