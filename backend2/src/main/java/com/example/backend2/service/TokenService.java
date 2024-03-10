package com.example.backend2.service;

import com.example.backend2.domain.entity.common.LoginUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenService {
    /**
     * 生成令牌
     *
     * @param loginUser 登录信息
     * @return 令牌
     */
    String createToken(LoginUser loginUser);

    /**
     * 获取用户信息
     *
     * @param request 请求对象
     * @return 用户信息
     */
    LoginUser getLoginUser(HttpServletRequest request);

    /**
     * 验证令牌
     *
     * @param user 用户信息
     */
    void verifyToken(LoginUser user);

    /**
     * 删除用户信息
     *
     * @param token 唯一标识
     */
    void delLoginUser(String token);
}
