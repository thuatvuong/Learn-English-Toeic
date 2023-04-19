package com.webtoeic.controller.client;

import com.webtoeic.entities.BaiThiThu;
import com.webtoeic.entities.CauHoiBaiThiThu;
import com.webtoeic.entities.KetQuaBaiTest;
import com.webtoeic.entities.NguoiDung;
import com.webtoeic.service.BaiThiThuService;
import com.webtoeic.service.CauHoiBaiThiThuService;
import com.webtoeic.service.KetQuaBaiTestService;
import com.webtoeic.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class BaiFullTestController {

    @Autowired
    private BaiThiThuService baiThiThuService;

    @Autowired
    private CauHoiBaiThiThuService cauHoiBaiThiThuService;

    @Autowired
    private KetQuaBaiTestService ketQuaBaiTestService;

    @Autowired
    private NguoiDungService nguoiDungService;

    @ModelAttribute("loggedInUser")
    public NguoiDung getSessionUser(HttpServletRequest request) {
        return (NguoiDung) request.getSession().getServletContext().getAttribute("loggedInUser");
    }

    @GetMapping("/listExam")
    public String getListExam(@RequestParam(defaultValue = "1") int page, Model model) {
        try {

            Page<BaiThiThu> baiThiThus = baiThiThuService.getBaiThiThu(page - 1, 4);
            int totalPage = baiThiThus.getTotalPages();
            List<Integer> pageList = new ArrayList<>();

            // lay ds cac trang
            if (page == 1 || page == 2) {
                for (int i = 2; i <= 3 && i <= totalPage; i++) {
                    pageList.add(i);
                }
            } else if (page == totalPage) {
                for (int i = totalPage; i >= totalPage - 2 && i > 1; i--) {
                    pageList.add(i);
                }

            } else {
                for (int i = page; i <= page + 1 && i <= totalPage; i++) {
                    pageList.add(i);
                }

                for (int i = page - 1; i >= page - 1 && i > 1; i--) {
                    pageList.add(i);
                }

                Collections.sort(pageList);
            }

            model.addAttribute("pageList", pageList);
            model.addAttribute("totalPage", totalPage);
            model.addAttribute("listData", baiThiThus.getContent());
            model.addAttribute("currentPage", page);
            return "client/listExam";
        } catch (Exception e) {
            System.out.println("error:" + e);
            return "client/error";
        }
    }

    @GetMapping("/doExam")
    public String DetailListening(Model model, @RequestParam("idExam") int id) {

        try {
            List<CauHoiBaiThiThu> list = cauHoiBaiThiThuService.getListCauHoi(baiThiThuService.getBaiThiThu(id).get(0));
            model.addAttribute("listQuestion", list);
            return "client/fullTestListen";

        } catch (Exception e) {
            System.out.println("error:" + e);
            return "client/error";
        }
    }

    @RequestMapping(value = "/saveResultUser/{examId}/{correctListening}/{correctReading}", method = RequestMethod.POST)
    public String showResultUser(Model model, @PathVariable("correctListening") int correctListening,
                                 @PathVariable("correctReading") int correctReading,
                                 @PathVariable("examId") int examId) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        NguoiDung currentUser = nguoiDungService.findByEmail(auth.getName());

        Date time = new Date();
        KetQuaBaiTest ketQuaBaiTest = new KetQuaBaiTest();
        ketQuaBaiTest.setNgaythi(time);
        ketQuaBaiTest.setBaithithu(baiThiThuService.getBaiThiThu(examId).get(0));
        ketQuaBaiTest.setCorrectlisten(correctListening);
        ketQuaBaiTest.setCorrectreading(correctReading);
        ketQuaBaiTest.setSocaudung(correctListening + correctReading);
        ketQuaBaiTest.setSocausai(100 - correctListening - correctReading);
        ketQuaBaiTest.setNguoidung(currentUser);


        return "client/resultTestUser";
    }

}
