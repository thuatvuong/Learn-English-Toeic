package com.webtoeic.controller.client;

import com.webtoeic.entities.NguoiDung;
import com.webtoeic.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ArticleController {

    @Autowired
    private NguoiDungService nguoiDungService;

    @ModelAttribute("loggedInUser")
    public NguoiDung getSession(HttpServletRequest request) {
        return (NguoiDung) request.getSession().getServletContext().getAttribute("loggedInUser");
    }

    @GetMapping("/listArticles")
    public String getAllArticles() {
        return "client/baibao";
    }

    @GetMapping("/article")
    public String getArticle(@RequestParam Long id) {
        return "client/chiTietBaiBao";
    }
}
