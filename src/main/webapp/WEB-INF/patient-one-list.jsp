<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${param.patientCode}번 님의 정보</h1>
<h2>${hospitalDTO.patientName}</h2>
<h2>${hospitalDTO.patientAge}</h2>
<h2>${hospitalDTO.patientGender}</h2>
<h2>${hospitalDTO.patientPhone}</h2>
<h2>${hospitalDTO.patientEmail}</h2>
<h2>${hospitalDTO.patientSick}</h2>
<h2>${hospitalDTO.patientAdmission}</h2>
<h2>${hospitalDTO.departmentCode}</h2>
</body>
</html>
