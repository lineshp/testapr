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
<form action="traceppl/countryInfo">
  
    
    <select name='selectedCountry'>  
   <c:forEach var="country" items="${countryList}">
       <option id="${country.name}" value="${country.name}">${country.name}</option>   
   </c:forEach>
</select>
<input type="submit" value="SUBMIT"/>
    </form>
</body>
</html>