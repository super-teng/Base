package transaction.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import transaction.dao.TransDao;

import javax.sql.DataSource;

/**
 * Created by Super腾 on 2017/1/6.
 */
/**
 * 继承JdbcDaoSupport这样可以使用我们的spring的jdbc模板
 */
@Repository
public class TransDaoImpl extends JdbcDaoSupport implements TransDao {

    //为我们的jdbc模板设置数据源十分关键这一步
    @Autowired
    public void setMyDataSource(DataSource dataSource){
        this.setDataSource(dataSource);
    }
    /**
     *
     * @param username 转账用户名（入）
     * @param money 转账金额
     */
    public void addMoney(String username,Double money) {
        //加钱
        String sql = "UPDATE bank SET money = money + ? WHERE username = ? ";
        //调用模板下面的更新方法对数据进行更新
        this.getJdbcTemplate().update(sql,money,username);
    }

    /**
     *
     * @param username 转账用户名（出）
     * @param money 转账金额
     */
    public void subMoney(String username,Double money) {
        //减钱
        String sql = "UPDATE bank SET money = money - ? WHERE username = ?  ";
        //调用模板下面的更新方法对数据进行更新
        this.getJdbcTemplate().update(sql,money,username);
    }
}
