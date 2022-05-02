<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News</title>
</head>
<body>
	<h1>전국 아파트 신문</h1> <button type="button" class="newsBtn" onClick="location.href='http://www.jkapt.com/sub.html?section=sc2&section2='">더보기</button>
	<br><br>
	<c:forEach var="item" items="${newsList}" step="1" varStatus="status">
	    <div><a href="${item[1]}">${item[0]}</a></div>
		<hr>
	</c:forEach>
	
</body>
</html>