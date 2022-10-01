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

<div class="pageing_area">
						<div class="pageing">
							
								<c:if test="${page<=1}"><a href="">&lt;</a></c:if>
								<c:if test="${page>1}"><a href="list?page=${page-1}">&lt;</a></c:if>
								<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
									<c:if test="${a == page}"><strong><a>${a}</a></strong></c:if>
									<c:if test="${a != page}"><a href="list?page=${a}">${a}</a></c:if>
								</c:forEach>
								<c:if test="${page >= maxpage}"><a href="">&gt;</a></c:if>
								<c:if test="${page<maxpage}"><a href="list?page=${page+1}">&gt;</a></c:if>
							
							
						</div>
					</div>

</body>
</html>