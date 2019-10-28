<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생산관리</title>
<script type="text/javascript">
</script>
<style>
fieldset{
	width:500px;
}
</style>
</head>
<body>
	<h2>생산관리 등록화면</h2>

	<form action="createPro.do" method="post">
		<fieldset>
			<legend>생산관리 등록화면</legend>
			<ul>
				<li>제품코드 <input type="text" name="code"></li>
				<li>제품이름 <input type="text" name="pname"></li>
				<li>제품원가 <input type="text" name="cost"></li>
				<li>목표수량 <input type="text" name="pnum"></li>
				<li>재고수량 <input type="text" name="jnum"></li>
				<li>출고가 <input type="text" name="sale"></li>
				<li>그룹이름 <select name="gcode">
				<c:forEach items="${gVO }" var="vo">
						<option value="${vo.gcode }">"${vo.gname }"</option>
				</c:forEach>
				</select></li>
			</ul>
			<input type="submit" value="등록"> <input type="button"
				value="메인화면" onclick='location.href="list.jsp"'>
		</fieldset>
	</form>
</body>
</html>