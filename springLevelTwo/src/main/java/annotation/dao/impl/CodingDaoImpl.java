package annotation.dao.impl;

import annotation.dao.CodingDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Super腾 on 2017/1/5.
 */
@Repository
public class CodingDaoImpl implements CodingDao {
    public void insertCoding() {
        System.out.println("插入数据");
    }

    public void deleteCoding() {
        System.out.println("删除数据");
    }

    public void updateCoding() {
        System.out.println("更新数据");
    }

    public void searchCoding() {
        System.out.println("查询数据");
    }
}
