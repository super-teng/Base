package transaction.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import transaction.service.TransService;

/**
 * Created by Super腾 on 2017/1/6.
 */
public class Test {

    public static void main(String[] args){
        ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        TransService t = (TransService) cc.getBean("transServiceImpl");
        t.transferMoneyLevelTwo("aaa","bbb",100d);
    }
}
