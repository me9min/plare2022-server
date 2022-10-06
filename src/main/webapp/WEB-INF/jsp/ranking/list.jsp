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
		</select> <input type="submit" value="바꾸기">
	</form>

	<table border="1px solid">
		<tr>
			<td>순위</td>
			<td>닉네임</td>
			<td>캐시</td>
			<td>스팀고유번호</td>
		</tr>
		<c:set var="i" value="1" />
		<c:if test="${limitStart eq 1 }">
			<c:set var="i" value="${limitStart }" />
		</c:if>
		<c:if test="${limitStart ne 1 }">
			<c:set var="i" value="${(limitStart - 1) * page + 1 }" />
		</c:if>
		<c:set var="a" value="${i }" />
		<c:forEach var="item" items="${gameList }">

			<tr>
				<td>${a }</td>
				<td>${item.name }</td>
				<td>${item.credits }</td>
				<td>${item.id }</td>
				<c:set var="a" value="${a + 1 }" />
			</tr>
		</c:forEach>
	</table>

	<div id="paging">

		<c:if test="${max > end }">

			<c:forEach var="a" varStatus="vs" begin="${start}" end="${end}"
				step="1">
				<a href="/ranking/list?limitStart=${a + start - 1 }"> ${a } </a>
				<c:set var="next" value="${a + start }" />
			</c:forEach>

		</c:if>


	</div>

</body>
</html>