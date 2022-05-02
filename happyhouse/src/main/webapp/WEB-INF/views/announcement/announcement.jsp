<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>announcement</title>
</head>
<body>
	<c:forEach var="item" items="${announcementList}" step="1" varStatus="status">

	<a href="/announcement/info/${item.announcementNo}"><div>
     <p>번호 : ${item.announcementNo}</p>
     <p>작성자 : ${item.userid}</p>
     <p>제목: ${item.subject}</p>
     <p>내용: ${item.content}</p>
     <p>시간: ${item.regtime}</p>
	</div></a>
	<hr>
</c:forEach>

</body>
</html>