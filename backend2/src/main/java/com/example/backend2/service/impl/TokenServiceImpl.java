package com.example.backend2.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.example.backend2.domain.entity.common.LoginUser;
import com.example.backend2.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {
    /**
     * 令牌剩余时间
     */
    private static final Long TOKEN_REMAINDER = 20 * 60 * 1000L;
    /**
     * 令牌自定义标识
     */
    @Value("${token.header}")
    private String header;
    /**
     * 令牌秘钥
     */
    @Value("${token.secret}")
    private String SECRET;
    /**
     * 发行人
     */
    @Value("${token.iss}")
    private String ISSUER;
    /**
     * 主题
     */
    @Value("${token.sub}")
    private String SUBJECT;
    /**
     * 令牌有效期
     */
    @Value("${token.ttl}")
    private Integer TTL;

    @Override
    public String createToken(LoginUser loginUser) {
        String uuid = UUID.fastUUID().toString();
        loginUser.setToken(uuid);
        refreshToken(loginUser);
        DateTime now = DateTime.now();
        Map<String, Object> map = new HashMap<>();
        map.put(JWTPayload.ISSUER, ISSUER); // 发行人
        map.put(JWTPayload.SUBJECT, SUBJECT); // 主题
        map.put(JWTPayload.AUDIENCE, loginUser.getUser().getUsername()); // 用户
        map.put(JWTPayload.ISSUED_AT, now); // 签发时间
        map.put(JWTPayload.NOT_BEFORE, now); // 生效时间
        map.put(JWTPayload.EXPIRES_AT, now.offsetNew(DateField.MINUTE, TTL)); // 过期时间
        map.put("uuid", uuid);
        // TODO: 2024/3/6 TOKEN存Redis，待优化
        return JWTUtil.createToken(map, SECRET.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public LoginUser getLoginUser(HttpServletRequest request) {
        String token = getAuthorization(request);
        if (StrUtil.isNotBlank(token)) {
            JWT jwt = JWTUtil.parseToken(token);
            String uuid = (String) jwt.getPayload("uuid");
            // TODO: 2024/3/6 从Redis获取
            return new LoginUser();
        }
        return null;
    }

    @Override
    public void verifyToken(LoginUser user) {
        long expireTime = user.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= TOKEN_REMAINDER) {
            refreshToken(user);
        }
    }

    @Override
    public void delLoginUser(String token) {

    }

    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    private void refreshToken(LoginUser loginUser) {
        long loginTime = System.currentTimeMillis();
        loginUser.setLoginTime(loginTime);
        loginUser.setExpireTime(loginTime + TTL * 60 * 1000);
    }

    /**
     * 获取请求令牌
     *
     * @param request 请求对象
     * @return 令牌
     */
    private String getAuthorization(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StrUtil.isNotBlank(token) && token.startsWith("Bearer ")) {
            token = token.replace("Bearer ", "");
        }
        return token;
    }
}
