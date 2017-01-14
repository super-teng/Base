package aop.Test;

import aop.dao.CodingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Super腾 on 2017/1/5.
 */
@Component
public class Test {
    @Autowired
    @Qualifier("coding")
    private CodingDao codingDao;

    public void insert(){
        codingDao.insert();
    }
    public void update(){
        codingDao.update();
    }
    public void delete(){
        codingDao.delete();
    }
    public void search(){
        codingDao.search();
    }

    public static void main(String[] args){
        ClassPathXmlApplicationContext c  = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        Test tt = (Test)c.getBean("test");
        tt.insert();
        tt.update();
        tt.search();
        tt.delete();


    }
}
