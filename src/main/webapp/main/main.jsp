<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Madimi+One&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<head>
    <title>Title</title>
</head>
<style>
    input,select{
        background-color: burlywood;
        border:none;
    }
    html{
        font-family: "Nanum Pen Script", cursive;
        font-weight: 400;
        font-style: normal;
    }
</style>
<body>
<h1>환자 데이터 관리 시스템</h1>
<h2>조회하고자 하는 환자의 아이디를 입력해주세요.</h2>
<form action="${pageContext.servletContext.contextPath}/hospital/patient" method="get">
    <input type="text" name="patientCode"/>
    <input type="submit" value="환자 조회"/>
</form>
<h2>환자 전체 조회</h2>
<form action="${pageContext.servletContext.contextPath}/hospital/patients" method="get">
    <button type="submit">전체 환자 정보 조회</button>
</form>
<h2>환자 추가</h2>
<form action="${pageContext.servletContext.contextPath}/hospital/insert" method="post">
    <p>환자 이름 : </p>
    <input type="text" name="patientName"/>
    <p>환자 나이 : </p>
    <input type="number" name="patientAge"/>
    <p>환자 성별 : </p>
    <select name="patientGender">
        <option>남</option>
        <option>여</option>
    </select>
    <p>환자 휴대폰 : </p>
    <input type="text" name="patientPhone"/>
    <p>환자 이메일 : </p>
    <input type="text" name="patientEmail"/>
    <p>환자 아픈 이유 : </p>
    <input type="text" name="patientSick"/>
    <p>환자 입원여부 : </p>
    <input type="text" name="patientAdmission"/>
    <p>환자 진료과 : </p>
    <input type="text" name="departmentCode"/>
    <input type="submit" value="환자 추가"/>
</form>
<h2>환자 이름 수정</h2>
<p>수정할 환자의 코드를 입력해주세요.</p>
<form action="${pageContext.servletContext.contextPath}/hospital/update" method="post">
<input type="text" name="patientCode"/>
<p>수정할 환자의 이름을 입력해주세요.</p>
<input type="text" name="patientName"/>
    <input type="submit" value="수정하기"/>
</form>
<h2>환자 정보 삭제</h2>
<form action="${pageContext.servletContext.contextPath}/hospital/delete" method="post">
    <p>삭제할 환자의 코드 입력</p>
    <input type="text" name="patientCode">
    <input type="submit" value="삭제"/>
</form>
</body>
</html>
