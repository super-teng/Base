package base;

import exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Super腾 on 2017/1/10.
 */
@Controller
public class BaseController {
    //设置一个检查错误信息的方法，当有地方抛出自定义异常的时候就会被这个方法所捕获到
    @ExceptionHandler(MyException.class)
    public String handlerException(Exception ex, HttpServletRequest request){
        request.setAttribute("error",ex.getMessage());
        request.setAttribute("message",ex.getMessage());
        return "error";
    }
}
