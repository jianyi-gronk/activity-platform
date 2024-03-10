package com.example.backend2.service.impl;

import cn.hutool.core.util.StrUtil;
import com.example.backend2.domain.entity.User;
import com.example.backend2.domain.entity.common.LoginUser;
import com.example.backend2.service.LoginService;
import com.example.backend2.service.TokenService;
import com.example.backend2.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserService userService;
    @Resource
    private TokenService tokenService;

    @Override
    public String login(String username, String password, String code, String uuid) {
        validateCaptcha(username, code, uuid); // 校验验证码
        loginPreCheck(username, password); // 密码前置校验
        User user = userService.lambdaQuery() //
                .eq(User::getUsername, username) //
                .eq(User::getPassword, password) //
                .one();
        if (user == null) {
            throw new RuntimeException("登陆失败！");
        }
        LoginUser loginUser = LoginUser.builder() //
                .userId(user.getId()) //
                .user(user) //
                .build();
        return tokenService.createToken(loginUser);
    }

    /**
     * 校验验证码
     *
     * @param username 用户名
     * @param code     验证码
     * @param uuid     唯一标识
     */
    private void validateCaptcha(String username, String code, String uuid) {
        // TODO: 2024/3/6 获取验证码开关，异步写入错误消息
        boolean captchaEnabled = false; // 获取验证码开关
        if (!captchaEnabled) {
            return;
        }
        // 校验Redis验证码
//        String verifyKey = CacheConstant.CAPTCHA_CODE_KEY + uuid;
//        String captcha = redisUtils.getCacheObject(verifyKey);
        String captcha = "";
        if (captcha == null) {
            throw new RuntimeException("验证码不存在！");
        }
        if (!code.equalsIgnoreCase(captcha)) {
            throw new RuntimeException("验证码错误！");
        }
    }

    /**
     * 登录前置校验
     *
     * @param username 用户名
     * @param password 密码
     */
    private void loginPreCheck(String username, String password) {
        // TODO: 2024/3/6 错误消息国际化、异步写入信息
        // 用户名或密码为空
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            throw new RuntimeException("用户名或密码不能为空！");
        }
        // 用户名不在指定范围内
        if (username.length() < 1 || username.length() > 20) {
            throw new RuntimeException("用户名长度不符合！");
        }
        // 密码如果不在指定范围内
        if (password.length() < 1 || password.length() > 20) {
            throw new RuntimeException("密码长度不符！");
        }
        // IP黑名单校验
        // TODO: 2024/3/6 IP黑名单校验
    }
}
