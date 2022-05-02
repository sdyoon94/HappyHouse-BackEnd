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

	글 번호 ${announcement.announcementNo} <br>
	작성자 : ${announcement.userid}	<br>
	제목 : ${announcement.subject}	<br>
	내용: ${announcement.content}		<br>
	시간: ${announcement.regtime}		<br>


</body>
</html>