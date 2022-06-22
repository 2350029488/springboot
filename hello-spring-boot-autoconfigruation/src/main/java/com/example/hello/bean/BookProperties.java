package com.example.hello.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("com.book")
public class BookProperties {
    private String prefix;
    public String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
