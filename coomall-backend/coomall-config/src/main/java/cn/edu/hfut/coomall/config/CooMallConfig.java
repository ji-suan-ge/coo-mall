package cn.edu.hfut.coomall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 葛学文
 * @date 2019/7/15 15:00
 */
@Component
@ConfigurationProperties(prefix = "coomall")
public class CooMallConfig {

    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
