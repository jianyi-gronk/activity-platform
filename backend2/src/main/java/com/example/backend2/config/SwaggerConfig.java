package com.example.backend2.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.Inet4Address;

@Slf4j
@EnableKnife4j
@Configuration
public class SwaggerConfig implements ApplicationListener<WebServerInitializedEvent> {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI() //
                .info(new Info() //
                        .title("活动报名与管理系统接口文档") // 标题
                        .description("活动报名与管理系统接口文档") // 描述
                        .termsOfService("服务条款地址") // 服务条款地址
                        .contact(new Contact() //
                                .name("jianyi-gronk") // 作者
                                .url("https://github.com/jianyi-gronk") // 地址
                                .email("2839458235@qq.com")) // 邮箱
                        .version("v1.0") // 版本号
                ) //
                .externalDocs(new ExternalDocumentation() //
                        .description("活动报名与管理系统接口文档") //
                        .url("http://127.0.0.1:8080"));
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        String hostAddress = Inet4Address.getLocalHost().getHostAddress(); // 获取端口号
        int port = event.getWebServer().getPort();
        String applicationName = event.getApplicationContext().getApplicationName();// 获取应用名
        log.info("-----------------------------------------------------");
        log.info("-\t本地地址：\thttp://{}:{}{}", hostAddress, port, applicationName);
        log.info("-\tSwagger文档：http://{}:{}{}/doc.html", hostAddress, port, applicationName);
        log.info("-----------------------------------------------------");
    }
}
