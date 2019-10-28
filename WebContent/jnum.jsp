<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹별 재고수량</title>
<style>
fieldset{
	width:500px;
}
</style>
</head>
<body>
<%
//ArrayList<ProductVO> vos= new ArrayList<ProductVO>();
@SuppressWarnings("unchecked")
ArrayList<ProductVO> vos = (ArrayList<ProductVO>) request.getAttribute("pVOs");
%>
	<h2>생산관리 그룹별 재고수량</h2>
	<fieldset>
		<legend>생산관리 그룹별 재고수량</legend>
		<table border="1">
			<tr><td>그룹이름</td><td>재고수량</td></tr>
			<% for(ProductVO e : vos) { %>
			<tr><td><%=e.getGname() %></td><td><%=e.getJnum() %></td></tr>
			<% } %>
		</table>
		<input type="button" value="메인화면" onclick='location.href="list.jsp"'>
	</fieldset>
</body>
</html>