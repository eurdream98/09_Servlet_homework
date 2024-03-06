package com.ohgiraffers.hospital.model.service;

import com.ohgiraffers.hospital.model.dao.HospitalMapper;
import com.ohgiraffers.hospital.model.dto.HospitalDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.mybatis.Template.getSqlSession;

public class HospitalService {
    private HospitalMapper hospitalMapper;
    public HospitalDTO selectOnePatient(int patientCode) {
        SqlSession sqlSession = getSqlSession();
        hospitalMapper = sqlSession.getMapper(HospitalMapper.class);
        HospitalDTO hospitalDTO = hospitalMapper.selectOnePatient(patientCode);
        sqlSession.close();
        return hospitalDTO;
    }

    public List<HospitalDTO> selectAllPatient() {
        SqlSession sqlSession = getSqlSession();
        hospitalMapper = sqlSession.getMapper(HospitalMapper.class);
        List<HospitalDTO> hospitalDTOList = hospitalMapper.selectAllPatient();
        sqlSession.close();
        return hospitalDTOList;
    }

    public int insertPatient(HospitalDTO hospitalDTO) {
        SqlSession sqlSession = getSqlSession();
        hospitalMapper = sqlSession.getMapper(HospitalMapper.class);
        int result = hospitalMapper.insertPatient(hospitalDTO);
        if(result>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public int updatePatient(HospitalDTO hospitalDTO) {
        SqlSession sqlSession = getSqlSession();
        hospitalMapper = sqlSession.getMapper(HospitalMapper.class);
        int result = hospitalMapper.updatePatient(hospitalDTO);
        if(result>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public int deletePatient(int patientCode) {
        SqlSession sqlSession = getSqlSession();
        hospitalMapper = sqlSession.getMapper(HospitalMapper.class);
        int result = hospitalMapper.deletePatient(patientCode);
        if(result>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }
}
