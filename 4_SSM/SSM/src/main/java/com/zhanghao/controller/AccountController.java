package com.zhanghao.controller;

import com.zhanghao.domain.Account;
import com.zhanghao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层查询所有");
        System.out.println("accountService = " + accountService);
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "success";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层保存账户");
        accountService.save(account);
        //转发
        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return;
    }
}
