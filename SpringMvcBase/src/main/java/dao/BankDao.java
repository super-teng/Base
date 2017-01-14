package dao;

import org.springframework.stereotype.Repository;
import po.Bank;

import java.util.List;

/**
 * Created by Super腾 on 2017/1/14.
 */
@Repository
public interface BankDao {
    //查询单条记录
    public Bank searchOneByUserName(String username);
    //查询多条记录
    public List<Bank> searchAll();
}
