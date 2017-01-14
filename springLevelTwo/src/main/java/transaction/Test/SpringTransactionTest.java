package transaction.Test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import transaction.service.TransService;
/**
 *
 * Created by Super腾 on 2017/1/6.
 * 使用spring-test+junit进行测试 加载spring配置文件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class SpringTransactionTest {

    @Autowired
    private TransService transService;
    @Test
    public void demo01(){
        transService.transferMoneyLevelOne("aaa","bbb",100d);
    }
}
