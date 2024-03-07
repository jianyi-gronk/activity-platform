package com.example.backend2.common.interceptor;

import cn.hutool.extra.servlet.JakartaServletUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWT;
import com.example.backend2.domain.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    String[] urls = {"/captcha", "/sys/login"};
    /**
     * 令牌秘钥
     */
    @Value("${token.secret}")
    private String SECRET;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI();
        // 白名单放行
        if (Arrays.stream(urls).anyMatch(uri::contains)) {
            return true;
        }
        String authorization = request.getHeader("Authorization");
        boolean verify = JWT.of(authorization).setKey(SECRET.getBytes(StandardCharsets.UTF_8)).verify();
        if (verify) {
            return true;
        }
        JakartaServletUtil.write(response, JSONUtil.toJsonStr(R.error("请求失败，请登录！")), MediaType.APPLICATION_JSON_VALUE);
        // 默认拦截
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
