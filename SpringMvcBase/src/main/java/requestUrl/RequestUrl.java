package requestUrl;

import dao.BankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import po.Bank;
import validator.po.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Super腾 on 2017/1/8.
 */
@Controller
public class RequestUrl {
    @RequestMapping(value ="/submit" ,method = RequestMethod.POST)
    public String answer(ModelMap modelMap,@RequestParam String username, @RequestParam String password,HttpSession session){
        if(username.equals("尚美奇")&&password.equals("6666")) {
            modelMap.addAttribute("username", username);
            modelMap.addAttribute("password", password);
            //将登陆用户放入到session中去
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            session.setAttribute("user",user);
            return "success";
        }else{
            modelMap.addAttribute("message","You are wrong");
            return "welcome";
        }
    }
    @Autowired
    private BankDao bankDao;
    @RequestMapping("/selectOne")
    public void selectOne(){
        Bank bank = bankDao.searchOneByUserName("aaa");
        System.out.println(bank.getUsername()+"-----"+bank.getMoney());
    }
    @RequestMapping("/selectAll")
    public void selectAll(){
        List<Bank> list = bankDao.searchAll();
        for(Bank b :list){
            System.out.println(b.getUsername()+"-----"+b.getMoney());
        }
    }
}
