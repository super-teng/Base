package transaction.dao;

/**
 * Created by Super腾 on 2017/1/6.
 */
public interface TransDao {
    /**
     *
     * @param username 转账用户名（入）
     * @param money 转账金额
     */
    public void addMoney(String username,Double money);
    /**
     *
     * @param username 转账用户名（出）
     * @param money 转账金额
     */
    public void subMoney(String username,Double money);
}
