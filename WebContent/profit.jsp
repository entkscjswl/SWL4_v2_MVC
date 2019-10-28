<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이익순위</title>
<style>
fieldset{
	width:500px;
}
</style>
</head>
<body>
	<h2>생산관리 이익우선</h2>

	<fieldset>
		<legend>이익순위</legend>
		<table border="1">
			<tr><td>제품이름</td><td>총이익 금액</td></tr>
			<c:forEach var="vo" items="${pVO}" >
				<tr><td>${vo.pname }</td><td>${vo.sale }</td></tr>
			</c:forEach>
		</table>
		<div class="button">
		<input type="button" value="메인화면" onclick='location.href="list.jsp"'>
		</div>
	</fieldset>
</body>
</html>