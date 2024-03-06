package com.ohgiraffers.hospital.controller;

import com.ohgiraffers.hospital.model.dto.HospitalDTO;
import com.ohgiraffers.hospital.model.service.HospitalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hospital/patient")
public class SelectOnePatient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int patientCode = Integer.parseInt(req.getParameter("patientCode"));
        HospitalService hospitalService = new HospitalService();
        HospitalDTO hospitalDTO = hospitalService.selectOnePatient(patientCode);
        String path = "";
        if(hospitalDTO!=null){
            req.setAttribute("hospitalDTO",hospitalDTO);
           path = "/WEB-INF/patient-one-list.jsp";
        }else{
            String message = "환자 조회에 실패하였습니다.";
            req.setAttribute("message",message);
            path = "/WEB-INF/errorPage/errorPage.jsp";
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }
}
