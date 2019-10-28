<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생산관리 시스템</title>
<script type="text/javascript">
function create(){
	location.href="create.do";
}
function searchCode(){
	location.href="search.jsp";
}
function pproduct(){
	location.href="pproduct.do";
}
function profit(){
	location.href="profit.do";
}
function jnum(){
	location.href="jnum.do";
}
</script>
<style>
h2{
	margin-left:40px;
}
fieldset{
	width:500px;
	margin-left:40px;
}
</style>
</head>
<body>
<h2>생산관리 시스템</h2>

<fieldset>
<legend>생산관리 메인메뉴</legend>
<button name="create" onclick="create()">제품입력</button>
<button onclick="searchCode()">제품조회</button>
<input type="button" name="pproduct" value="우선생산제품" onclick="pproduct()">
<input type="button" name="profit" value="이익우선" onclick="profit()">
<input type="button" name="jnum" value="그룹별재고수량" onclick="jnum()">
</fieldset>
</body>
</html>