package com.dog.it;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication()
public class SpringbootAdminApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringbootAdminApplication.class);
        //关闭默认banner //开起
        application.setBannerMode(Banner.Mode.CONSOLE);
        //关闭启用信息
        application.setLogStartupInfo(false);
        //启用服务
        application.run(args);

    }

}
