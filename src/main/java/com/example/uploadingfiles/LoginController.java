package com.example.uploadingfiles;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @RequestMapping(value = "/toLogin", method = RequestMethod.POST)
    public String toLogin(@RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password, Map<String, Object> map, HttpSession session) {

        if (!StringUtils.isEmpty(username) && username.equals("burning") && "123456".equals(password)) {
            session.setAttribute("loginUser", username);
            return "test";
        } else {
            map.put("msg", "用户名或密码错误");
            return "index";
        }
    }

    @RequestMapping(value = "/toRegister", method = RequestMethod.POST)
    public String toRegister(HttpServletRequest request,RedirectAttributes redirectAttributes) {
        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String passWd = request.getParameter("password2");
        return "redirect:/login";

    }
    @GetMapping(value="/login")
    public String login(Model model) {
        model.addAttribute("msg", "登陆后可上传私密文件");
        return "index";
    }
    @GetMapping(value="/register")
    public String register(Model model) {
        model.addAttribute("msg", "注册后享专属文件系统");
        return "register";
    }
    
}