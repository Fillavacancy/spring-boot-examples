/**
 * FileName: HelloController
 * Author:   xiangjunzhong
 * Date:     2018/1/9 9:33
 * Description:
 */
package com.xjz.example.hello.controller;

import com.xjz.example.hello.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author xiangjunzhong
 * @create 2018/1/9 9:33
 * @since 1.0.0
 */
@Controller
public class HelloController {

    @Value("${loca-ip}")
    private String ip;

    //指定默认值 但是不能配置
    @Value("${loca-port:8080}")
    private String port;

    @Autowired
    private User user;

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        System.out.println(ip);
        System.out.println(port);
        System.out.println(user);
        //int i = 1 / 0;
        return "成功";
    }

    /**
     * 使用模板引擎
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("name", "张三");
        return "index";
    }
}