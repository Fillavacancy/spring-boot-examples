/**
 * FileName: User
 * Author:   xiangjunzhong
 * Date:     2018/1/11 11:11
 * Description:
 */
package com.xjz.example.hello.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author xiangjunzhong
 * @create 2018/1/11 11:11
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "users")
public class User {
    private String name;

    private Integer age;

    private String sex;

    private List<String> ip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getIp() {
        return ip;
    }

    public void setIp(List<String> ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", ip=" + ip +
                '}';
    }
}