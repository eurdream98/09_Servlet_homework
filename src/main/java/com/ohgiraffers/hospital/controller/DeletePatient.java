package com.ohgiraffers.hospital.controller;

import com.ohgiraffers.hospital.model.dto.HospitalDTO;
import com.ohgiraffers.hospital.model.service.HospitalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hospital/delete")
public class DeletePatient extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int patientCode = Integer.parseInt(req.getParameter("patientCode"));
        HospitalService hospitalService = new HospitalService();
        int result = hospitalService.deletePatient(patientCode);
        if(result>0){
            resp.sendRedirect(req.getContextPath()+"/hospital/patients");
        }else{
            req.setAttribute("message","삭제에 실패하였습니다.");
            req.getRequestDispatcher("/WEB-INF/errorPage/errorPage.jsp").forward(req,resp);
        }
    }
}
