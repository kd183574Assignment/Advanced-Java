<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dcb" class="com.sunbeam.beans.DeleteCandBean"  />
	<jsp:setProperty property="id" name="dcb" param="id"/>
	${ dcb.deleteCandidate() }
	<c:redirect url="result.jsp" />

</body>
</html>