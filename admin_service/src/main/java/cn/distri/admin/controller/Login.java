package cn.distri.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登陆模块
 *
 * @author-liudongxu
 * @created 2019-11-28 17:54
 */
@Controller
public class Login {
    @RequestMapping("/login")
    public void login(){
        System.out.println("登陆了！");
    }
}
