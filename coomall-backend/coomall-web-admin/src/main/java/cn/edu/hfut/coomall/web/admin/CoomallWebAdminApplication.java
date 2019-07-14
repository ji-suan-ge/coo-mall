package cn.edu.hfut.coomall.web.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"cn.edu.hfut.coomall"})
@ComponentScan(basePackages = {"cn.edu.hfut.coomall"})
public class CoomallWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoomallWebAdminApplication.class, args);
    }

}
