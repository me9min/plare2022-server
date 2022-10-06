<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="/ranking/list">
	<select name="paging_count">
		<option value="5">5</option>
		<option value="10">10</option>
	</select>
	<input type="submit" value="바꾸기">
</form>

<table border="1px solid" >
<tr>
	<td>순위</td> <td>닉네임</td> <td>캐시</td> <td>스팀고유번호</td>
</tr>
<c:set var="i" value="1" />
<c:forEach var="item" items="${gameList }">

<tr>
<td>${i }</td>  <td> ${item.name }</td> <td>${item.credits }</td> <td>${item.id }</td>
<c:set var="i" value="${i + 1 }" />
</tr>
</c:forEach>
</table>



</body>
</html>