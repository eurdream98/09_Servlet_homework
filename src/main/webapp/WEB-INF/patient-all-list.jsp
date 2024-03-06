<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table,td,th{
        border:solid 1px;
        background-color: lightblue;
    }
</style>
<body>
<h1>전체 환자 정보 조회 결과</h1>
<table>
    <th>환자 코드</th>
    <th>환자 이름</th>
    <th>환자 나이</th>
    <th>환자 성별</th>
    <th>환자 전화번호</th>
    <th>환자 이메일</th>
    <th>환자 아픈이유</th>
    <th>환자 입원여부</th>
    <th>환자 진료과</th>
    <c:forEach items="${hospitalDTOS}" var="patient">
        <tr>
        <td>${patient.patientCode}</td>
        <td>${patient.patientName}</td>
        <td>${patient.patientAge}</td>
        <td>${patient.patientGender}</td>
        <td>${patient.patientPhone}</td>
        <td>${patient.patientEmail}</td>
        <td>${patient.patientSick}</td>
        <td>${patient.patientAdmission}</td>
        <td>${patient.departmentCode}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
