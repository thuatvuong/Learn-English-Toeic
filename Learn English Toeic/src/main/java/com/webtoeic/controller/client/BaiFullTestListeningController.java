package com.webtoeic.controller.client;

import com.webtoeic.entities.CauHoiBaiThiThu;
import com.webtoeic.entities.KetQuaBaiTest;
import com.webtoeic.entities.NguoiDung;
import com.webtoeic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BaiFullTestListeningController {

    @Autowired
    private BaiThiThuService baiThiThuService;

    @Autowired
    private CauHoiBaiThiThuService cauHoiBaiThiThuService;

    @Autowired
    private KetQuaBaiTestService ketQuaBaiTestService;

    @Autowired
    private NguoiDungService nguoiDungService;

    @ModelAttribute("loggedInUser")
    public NguoiDung getSession(HttpServletRequest request) {
        return (NguoiDung) request.getSession().getServletContext().getAttribute("loggedInUser");
    }

    @RequestMapping(value = "/showResultListening/{examId}/{socaudung}", method = RequestMethod.POST)
    public String showResult(Model model, @RequestBody String[] jsonAnswerUser,
                             @PathVariable("examId") int examId,
                             @PathVariable("socaudung") String socaudung) {

        List<CauHoiBaiThiThu> list = cauHoiBaiThiThuService.getListCauHoi(baiThiThuService.getBaiThiThu(examId).get(0));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        NguoiDung nguoiDung = nguoiDungService.findByEmail(auth.getName());

        for (int i = 0; i < 50; i++) {
            list.get(i).setDapAnUser(jsonAnswerUser[i]);
        }

        model.addAttribute("socaudung", socaudung);
        model.addAttribute("listQuestion", list);

        return "client/listeningResult";
    }
}
