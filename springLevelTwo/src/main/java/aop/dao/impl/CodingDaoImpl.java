package aop.dao.impl;

import aop.dao.CodingDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Super腾 on 2017/1/5.
 */
@Repository("coding")
public class CodingDaoImpl implements CodingDao {

    public int insert() {
        System.out.println("插入数据");
        return 1;
    }

    public void search() {
        System.out.println("查找数据");
    }

    public void update() {
        System.out.println("更新数据");
    }

    public void delete() {
        System.out.println("删除数据");
    }
}
