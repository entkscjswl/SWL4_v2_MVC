<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	int rs= (int)request.getAttribute("dResult");
	if(rs==1){
%>
<script type="text/javascript">
	window.alert("삭제 성공하였습니다.");
	location.href="list.jsp";
</script>
<%
	}else{
%>
<script type="text/javascript">
	window.alert("삭제 실패하였습니다.");
	window.history.go(-1);
</script>
<%
	}
%>
</body>
</html>