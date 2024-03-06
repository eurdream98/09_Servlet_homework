package com.ohgiraffers.hospital.controller;

import com.ohgiraffers.hospital.model.dto.HospitalDTO;
import com.ohgiraffers.hospital.model.service.HospitalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/hospital/patients")
public class SelectAllPatient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        HospitalService hospitalService = new HospitalService();
        hospitalDTOS = hospitalService.selectAllPatient();

        String path = "";
        if(hospitalDTOS!=null && !hospitalDTOS.isEmpty()){
            req.setAttribute("hospitalDTOS",hospitalDTOS);
            path="/WEB-INF/patient-all-list.jsp";
        }else{
            String message = "환자 전체 조회에 실패하였습니다.";
            req.setAttribute("message",message);
            path="/WEB-INF/errorPage/errorPage.jsp";
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }
}
