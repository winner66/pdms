package com.chk.pdms.system.controller;

import com.chk.pdms.common.annotation.Log;
import com.chk.pdms.common.controller.BaseController;
import com.chk.pdms.common.domain.Tree;
import com.chk.pdms.common.utils.MD5Utils;
import com.chk.pdms.common.utils.R;
import com.chk.pdms.common.utils.ShiroUtils;
import com.chk.pdms.system.domain.MenuDO;
import com.chk.pdms.system.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MenuService menuService;

    @GetMapping({"/", ""})
    String welcome(Model model) {

        return "redirect:/index";
    }

//    @Log("请求访问主页")
    @GetMapping({"/index"})
    String index(Model model) {
        List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
        model.addAttribute("menus", menus);
        model.addAttribute("name", getUser().getName());
//        FileDO fileDO = fileService.get(getUser().getPicId());
//        if (fileDO != null && fileDO.getUrl() != null) {
//            if (fileService.isExist(fileDO.getUrl())) {
//                model.addAttribute("picUrl", fileDO.getUrl());
//            } else {
//                model.addAttribute("picUrl", "/img/photo_s.jpg");
//            }
//        } else {
//            model.addAttribute("picUrl", "/img/photo_s.jpg");
//        }
        model.addAttribute("username", getUser().getUsername());
        return "index_v1";
    }

    @GetMapping("/login")
    String login(Model model) {
        return "login";
    }

    @Log("登录")
    @PostMapping("/login")
    @ResponseBody
    R ajaxLogin(String username, String password, HttpServletRequest request) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return R.ok();
        } catch (AuthenticationException e) {
            return R.error("用户或密码错误");
        }
    }

    @GetMapping("/logout")
    String logout() {
        ShiroUtils.logout();
        return "redirect:/login";
    }

    @GetMapping("/main")
    String main() {
        return "main";
    }

    /**
     * 生成验证码
     */
//    @GetMapping(value = "/getVerify")
//    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
//            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
//            response.setHeader("Cache-Control", "no-cache");
//            response.setDateHeader("Expire", 0);
//            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
//            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
//        } catch (Exception e) {
//            logger.error("获取验证码失败>>>> ", e);
//        }
//    }

}
