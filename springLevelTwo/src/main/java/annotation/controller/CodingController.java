package annotation.controller;

import annotation.service.CodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * Created by Super腾 on 2017/1/5.
 * 控制层
 */
@Controller
public class CodingController {
    @Autowired
    private CodingService codingService;
    public void insertCoding(){
        codingService.insertCoding();
    }
    public void deleteCoding(){
        codingService.deleteCoding();
    }
    public void updateCoding(){
        codingService.updateCoding();
    }
    public void searchCoding(){
        codingService.searchCoding();
    }
    public static void main(String[] args){
        ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        CodingController c = (CodingController) cc.getBean("codingController");
        c.insertCoding();
        c.deleteCoding();
        c.updateCoding();
        c.searchCoding();
    }
}
