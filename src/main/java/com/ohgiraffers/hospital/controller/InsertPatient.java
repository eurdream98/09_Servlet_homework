package com.ohgiraffers.hospital.controller;

import com.ohgiraffers.hospital.model.dto.HospitalDTO;
import com.ohgiraffers.hospital.model.service.HospitalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hospital/insert")
public class InsertPatient extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String patientName = req.getParameter("patientName");
        int patientAge = Integer.parseInt(req.getParameter("patientAge"));
        String patientGender = req.getParameter("patientGender");
        String patientPhone = req.getParameter("patientPhone");
        String patientEmail = req.getParameter("patientEmail");
        String patientSick = req.getParameter("patientSick");
        String patientAdmission = req.getParameter("patientAdmission");
        int departmentCode = Integer.parseInt(req.getParameter("departmentCode"));

        HospitalDTO hospitalDTO = new HospitalDTO(patientName,patientAge,patientGender,patientPhone,patientEmail,patientSick,patientAdmission,departmentCode);

        HospitalService hospitalService = new HospitalService();
        int result = hospitalService.insertPatient(hospitalDTO);
        if(result>0){
            resp.sendRedirect(req.getContextPath()+"/hospital/patients");
        }else{
            String message = "환자 추가에 실패하였습니다.";
            req.setAttribute("message",message);
            req.getRequestDispatcher("/WEB-INF/errorPage/errorPage.jsp").forward(req,resp);
        }
    }
}
