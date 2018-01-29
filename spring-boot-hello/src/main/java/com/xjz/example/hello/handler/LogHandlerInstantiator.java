/**
 * FileName: LogHandlerInstantiator
 * Author:   xiangjunzhong
 * Date:     2018/1/12 17:09
 * Description:
 */
package com.xjz.example.hello.handler;

import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author xiangjunzhong
 * @create 2018/1/12 17:09
 * @since 1.0.0
 */
public class LogHandlerInstantiator implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "");
        errorPageRegistry.addErrorPages(e404);
    }
}