package url;

import dao.BankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import po.Bank;

/**
 * Created by Super腾 on 2017/1/8.
 * 读且http请求中的url参数之后跳转到新的页面中去
 */
@Controller
@RequestMapping("/")
public class UrlRead {
    /**
     * 以get形式访问根路径时进入这个方法并跳到welcome页面中去
     * @param modelMap 跳转路径名称及所携带的渲染数据
     * @return 跳转路径的url
     */
    @RequestMapping(method = RequestMethod.GET)
    public String toWelcomePage(ModelMap modelMap){
        modelMap.addAttribute("message","Welcome My Friend");
        return "welcome";
    }

}
