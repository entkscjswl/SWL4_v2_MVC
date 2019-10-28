<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생산관리 수정화면</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	int rs= (int)request.getAttribute("uResult");
	if(rs==1){
%>
<script type="text/javascript">
	window.alert("수정 성공하였습니다~~");
	location.href="list.jsp";
</script>
<%
	} else {
%>
<script type="text/javascript">
	window.alert("수정 실패;;");
	window.history.go(-1);
</script>
<%
	}
%>
</body>
</html>