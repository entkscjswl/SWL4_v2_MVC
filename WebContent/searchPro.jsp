<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.*" %>
<html>
<head>
<title>생산관리</title>
<script type="text/javascript">
function main(){
	location.href="main.html";
}
function searchCode(){
	location.href="search.jsp";
	//document.search.action="search.jsp";
	//document.search.submit();	
}
function update(){
	document.search.action="update.do";
	document.search.submit();	
}
function del(){
	document.search.action="delete.do";
	document.search.submit();	
}
</script>
<style>
fieldset{
	width:500px;
}
</style>
</head>
<body>
	<h2>생산관리 조회 &amp; 수정 화면</h2>
	
	<form id="search" name="search" method="post">
		<fieldset>
			<legend>생산관리 조회화면</legend>
			<ul>
				<li>제품코드 <input type="text" name="code" value="${pVO.code }"></li>
				<li>제품이름 <input type="text" name="pname" value="${pVO.pname }"></li>
				<li>제품원가 <input type="text" name="cost" value="${pVO.cost }"></li>
				<li>목표수량 <input type="text" name="pnum" value="${pVO.pnum }"></li>
				<li>재고수량 <input type="text" name="jnum" value="${pVO.jnum }"></li>
				<li>출고가 <input type="text" name="sale" value="${pVO.sale }"></li>
				<li>그룹이름 <select name="gcode">
				<c:forEach var="vo" items="${gVO}" >
						<option value="${vo.gcode }"
							<c:if test="${vo.gcode eq pVO.gcode }">
							selected
							</c:if>
							>
							${vo.gname }
						</option>
					</c:forEach>
					</select>
				</li>
			</ul>
			<input type="button" value="조회" onclick="searchCode()">
			<input type="button" value="수정" onclick="update()">
			<input type="button" value="삭제" onclick="del()">
			<input type="button" value="메인화면" onclick='location.href="list.jsp"'>
			
		</fieldset>
	</form>

</body>
</html>