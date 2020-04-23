package com.lagou.edu.controller;

import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/getUserList.do")
    @ResponseBody
    public ModelAndView getUserList(){
        ModelAndView mv = new ModelAndView("user_list");
        mv.addObject("list", iUserService.getUserList());
        return mv;
    }

    @RequestMapping("/addUser.do")
    public String addUser(Resume resume){
        iUserService.addUser(resume);
        return "redirect:getUserList.do";
    }

    @RequestMapping("/updateUser.do")
    public String updateUser(Resume resume){
        iUserService.addUser(resume);
        return "redirect:getUserList.do";
    }

    @RequestMapping("/deleteUser.do")
    @ResponseBody
    public void deleteUser(Long id){
        iUserService.deleteUser(id);
    }


    @RequestMapping("/userLogin.do")
    public String userLogin(HttpServletRequest request, HttpServletResponse response,String username,String password){
        Cookie cookie = new Cookie("user_info",String.format("%s,%s",username,password));
        response.addCookie(cookie);
        return "redirect:getUserList.do";
    }
}
