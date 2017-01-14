package transaction.service;

/**
 * Created by Super腾 on 2017/1/6.
 */
public interface TransService {
    public void transferMoneyLevelOne(String outUser,String inUser,Double money);
    public void transferMoneyLevelTwo(String outUser,String inUser,Double money);
}
