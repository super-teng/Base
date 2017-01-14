package pathUrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Super腾 on 2017/1/8.
 * 读取路径中的参数并传入下面一个页面当中去
 */
@Controller
@RequestMapping("/read")
public class ReadPathUrl {
    /**
     * 从url接受参数并传到下一页面中去
     * @param name 姓名
     * @param age 年龄
     * @return modelAndView模型
     */
    @RequestMapping(value = "/{name}/{age}",method = RequestMethod.GET)
    public ModelAndView read( @PathVariable("name") String name,@PathVariable("age") int age){
        ModelAndView modelAndView = new ModelAndView("readPath");
        modelAndView.addObject("name",name);
        modelAndView.addObject("age",age);
        return modelAndView;
    }
}
