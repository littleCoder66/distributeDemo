package com.distri.ontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登陆用接口
 *
 * @author-liudongxu
 * @created 2019-11-28 17:41
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
     public void login(){
        System.out.println("登陆成功");
     }
}
