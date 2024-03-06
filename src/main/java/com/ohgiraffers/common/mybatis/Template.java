package com.ohgiraffers.common.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    /*SqlSessionFactory는 애플리케이션을 실행하는 동안 존재해야 하며
     * 애플리케이션이 실행되는 동안 여러 차례 SqlSessionFactory를 다시 빌드하지 않는 것이 좋은 형태이다.
     * 애플리케이션 스코프로 관리하기 가장 간단한 방법은 싱글톤 패턴을 이용하는 것이다.
     * singleton : 오로지 1개의 객체만 생성
     * */
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession(){
        if(sqlSessionFactory ==null){
            String resource = "mybatis/mybatis-config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        return sqlSession;
    }
}
