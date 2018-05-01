package cn.nuaa.tomax.service.impl;

import cn.nuaa.tomax.dao.IHelloDao;
import cn.nuaa.tomax.entity.HelloEntity;
import cn.nuaa.tomax.entity.ResultCause;
import cn.nuaa.tomax.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/5/1 0:04
 */
@Service
public class HelloServiceImpl implements IHelloService{

    @Resource
    private IHelloDao helloDao;

    @Override
    public ResultCause addHello(HelloEntity bean) {
        ResultCause result = new ResultCause();
        String sql = "insert into hello (name,signature) values (:name,:signature)";
        helloDao.saveHello(sql,bean);
        result.setCode(ResultCause.SUCCESS_CODE);
        result.setDesc("添加数据成功");
        return result;
    }

    @Override
    public List<HelloEntity> listHello() {
        String sql = "select * from hello";
        return helloDao.listHello(sql,new Object[]{});
    }

    @Override
    public ResultCause updateHelloData(HelloEntity bean) {
        ResultCause result = new ResultCause();
        String sql = "update hello set signature = ? where name = ?";
        helloDao.updateHelloData(sql,new Object[]{bean.getSignature(),bean.getName()});
        result.setCode(ResultCause.SUCCESS_CODE);
        result.setDesc("更新数据成功");
        return result;
    }

    @Override
    public ResultCause removeHelloData(String name) {
        ResultCause result = new ResultCause();
        String sql = "delete from hello where name = ?";
        helloDao.removeHelloData(sql,new Object[]{name});
        result.setCode(ResultCause.SUCCESS_CODE);
        result.setDesc("删除数据成功");
        return result;
    }
}
