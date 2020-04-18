<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 
 <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>REPORTED CASES</h2></caption>
            <tr>
                <th>COUNTRY</th>
                <th>CONFIRMED</th>
                <th>RECOVERED</th>
                <th>DEATHS</th>
            </tr>
         
                <tr>
                    <td><c:out value="${caseInfo.country}" /></td>
                    <td><c:out value="${caseInfo.confirmed}" /></td>
                    <td><c:out value="${caseInfo.recovered}" /></td>
                    <td><c:out value="${caseInfo.deaths}" /></td>
                </tr>
         
        </table>
    </div>
    
</body>
</html>