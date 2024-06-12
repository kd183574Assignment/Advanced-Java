<%@page import="com.sunbeam.pojos.Candidate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CANDIDATES</title>
</head>
<body>

	<h3>${initParam.appTitle}</h3>
	Hello, ${lb.user.firstName} ${lb.user.lastName} <hr/>
	
	<jsp:useBean id='clb' class="com.sunbeam.beans.CandidateListBean" />
	 ${ clb.fetchCandidates() }
	 
	 <form method="post" action="vote.jsp">
	 	<c:forEach var="e" items="${clb.candidateList}">
	 		<input type="radio" name="candidate" value="${e.id }"/> ${e.name} - ${e.party} <br/>
	 		
	 	</c:forEach>
	 	<br/> <input type="submit" value="Vote"/>
	 
	 </form>

</body>
</html>