<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
fieldset{
	width:500px;
}
</style>
</head>
<body>
	<h2>생산관리 제품조회</h2>
	<form action="searchPro.do" method="post">
		<fieldset>
			<legend>생산관리 제품조회</legend>
			제품코드<input type="text" name="code"><br>
			<input type="submit" value="조회">
			<input type="button" value="메인화면" onclick='location.href="list.jsp"'>
		</fieldset>
	</form>
</body>
</html>