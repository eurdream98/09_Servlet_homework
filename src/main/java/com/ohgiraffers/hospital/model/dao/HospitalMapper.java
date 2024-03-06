package com.ohgiraffers.hospital.model.dao;

import com.ohgiraffers.hospital.model.dto.HospitalDTO;

import java.util.List;

public interface HospitalMapper {
    HospitalDTO selectOnePatient(int patientCode);

    List<HospitalDTO> selectAllPatient();

    int insertPatient(HospitalDTO hospitalDTO);

    int updatePatient(HospitalDTO hospitalDTO);

    int deletePatient(int patientCode);
}
