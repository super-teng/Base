package interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Super腾 on 2017/1/10.
 * 当session中存在用户信息的时候才可以让当前用户访问用户中心，如果不存在则不可以进行访问
 */
public class MyInterceptor implements HandlerInterceptor{

    //object handler是指controller所注释下的方法名称
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else{
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
