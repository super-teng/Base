package transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transaction.dao.TransDao;
import transaction.service.TransService;

/**
 * Created by Super腾 on 2017/1/6.
 */
@Service
@Transactional
public class TransServiceImpl implements TransService {
    @Autowired
    private TransDao transDao;
    public void transferMoneyLevelOne(String outUser, String inUser, Double money) {
        transDao.addMoney(inUser,money);
        transDao.subMoney(outUser,money);
    }

    public void transferMoneyLevelTwo(String outUser, String inUser, Double money) {
        transDao.addMoney(inUser,money);
        int i= 1/0;
        transDao.subMoney(outUser,money);
    }
}
