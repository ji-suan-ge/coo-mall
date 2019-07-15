package cn.edu.hfut.coomall.config.interceptor;

import cn.edu.hfut.coomall.config.annotation.LoginRequired;
import cn.edu.hfut.coomall.util.ResultUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author 葛学文
 * @date 2019/7/15 14:27
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {


    @Value("${coomall.identifier}")
    private String identifier;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        if (methodAnnotation != null) {
            return checkLogin(request, response);
        }
        return true;
    }

    private boolean checkLogin(HttpServletRequest request,
                                    HttpServletResponse response)
            throws IOException {
        Object object = request.getSession().getAttribute(identifier);
        if (object == null) {
            response.setStatus(401);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            ObjectMapper objectMapper = new ObjectMapper();
            printWriter.print(
                    objectMapper.writeValueAsString(
                            ResultUtil.error(4000, "Unauthorized")
                    )
            );
            printWriter.flush();
            printWriter.close();
            return false;
        }
        return true;
    }
}