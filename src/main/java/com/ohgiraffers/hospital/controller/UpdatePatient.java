package com.ohgiraffers.hospital.controller;

import com.ohgiraffers.hospital.model.dto.HospitalDTO;
import com.ohgiraffers.hospital.model.service.HospitalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hospital/update")
public class UpdatePatient extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int patientCode = Integer.parseInt(req.getParameter("patientCode"));
        String patientName = req.getParameter("patientName");

        HospitalService hospitalService = new HospitalService();
        HospitalDTO hospitalDTO = new HospitalDTO();
        hospitalDTO.setPatientCode(patientCode);
        hospitalDTO.setPatientName(patientName);
        int result = hospitalService.updatePatient(hospitalDTO);
        if(result>0){
            resp.sendRedirect(req.getContextPath()+"/hospital/patient?patientCode="+patientCode);
        }else{
            req.setAttribute("message","수정에 실패하였습니다.");
            req.getRequestDispatcher("/WEB-INF/errorPage/errorPage.jsp").forward(req,resp);
        }
    }
}
