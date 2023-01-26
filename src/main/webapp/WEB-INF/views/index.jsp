<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	뭘봐
	
	
<script>
const isOk = '<c:out value="${isOk}"/>';
console.log(isOk);
if(isOk == 1){
	alert("로그인되었습니다");
}
</script>
</body>
</html>