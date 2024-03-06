package com.example.backend2.service;

public interface LoginService {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 令牌
     */
    String login(String username, String password, String code, String uuid);
}
