package validator.controller;

import base.BaseController;
import exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import validator.po.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Super腾 on 2017/1/9.
 */
@Controller
public class RegisterController extends BaseController{
    /**
     * 判断注册是否合法
     * @param user 注册所对应的PO实体类
     * @param result 判断当前注册中是否合法，存储验证结果的
     * @param modelMap 当前的视图数据包装类
     * @return 部分视图路径
     */
    @RequestMapping("/doRegister")
    public String registerJudge(@Valid User user, BindingResult result, ModelMap modelMap){
        System.out.println(user.getUsername()+"----");
        //如果验证信息中存在错误信息的话
        if(result.hasErrors()){
            //把产生的所有验证错误信息存储在一个集合当中去
            List<FieldError> errorList = result.getFieldErrors();
            //遍历错误集合，把错误信息输出出来，并且把错误的域当做键，错误的信息当做值返回回去，前端通过EL来通过键来取值
            for(FieldError error : errorList){
                System.out.println(error.getField()+"--"+error.getDefaultMessage());
                //getField();获取当前的键 ，getDefaultMessage();获取当前的错误信息
                modelMap.addAttribute("ERR_"+error.getField(), error.getDefaultMessage());
            }
            return "register";
        }
        //验证正确转发到成功页面
        modelMap.addAttribute("username",user.getUsername());
        return "success";
    }
    @RequestMapping("/register")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/userCenter")
    public String toUserCenter(){
        return "usercenter";
    }
    @RequestMapping("logOut")
    public String logOut(HttpSession session){
        session.removeAttribute("user");
        return "welcome";
    }
    @RequestMapping("exceptionTest")
    public void  testException() throws MyException {
        throw new MyException("Test Exception!!!");
    }
}
