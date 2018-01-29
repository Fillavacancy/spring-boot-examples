/**
 * FileName: GlobalExceptionHandler
 * Author:   xiangjunzhong
 * Date:     2018/1/9 9:35
 * Description: SpringBoot 全局捕获异常
 */
package com.xjz.example.hello.handler;

import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈SpringBoot 全局捕获异常〉
 *
 * @author xiangjunzhong
 * @create 2018/1/9 9:35
 * @since 1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "500");
        result.put("msg", "系统Bug，杀了一个程序员祭天!");
        return result;
    }
}