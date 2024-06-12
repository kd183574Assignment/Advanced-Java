<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE CANDIDATE</title>
</head>
<body>
	<h3>${initParam.appTitle}</h3>
	
	<jsp:useBean id="ucb" class="com.sunbeam.beans.UpdateCandidateBean"/>
	
	
	<jsp:setProperty property="*" name="ucb"/>
	
	${ ucb.updateCandidate()}
	
	<c:choose>
		<c:when test="${ucb.count == 1}">
			<c:redirect url="result.jsp"/>
		</c:when>
		
		<c:otherwise>
			Candidate Update Failed. <br/> <br/>
			<a href="result.jsp">SHOW RESULT </a>
		</c:otherwise>
	
	</c:choose>
	
</body>
</html>