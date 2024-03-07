package com.example.backend2.controller.system;

import com.example.backend2.domain.R;
import com.example.backend2.domain.entity.common.LoginBody;
import com.example.backend2.service.LoginService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口
 */
@Tag(name = "登录接口", description = "登录接口")
@RestController
@RequestMapping("/sys")
public class LoginController {
    @Resource
    private LoginService loginService;

    /**
     * 登录
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public R login(@RequestBody LoginBody loginBody) {
        String authorization = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(), loginBody.getUuid());
        return R.success("登录成功！") //
                .put("token", authorization);
    }
}
