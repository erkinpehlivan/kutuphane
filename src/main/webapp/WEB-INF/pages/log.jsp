<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9">
<title>LOGLAR</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

th {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<h1>Loglar</h1>

	<form:form modelAttribute="user">
		<table>
			<tr>
				<td><spring:message code="name" /></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td colspan="3">
					<button>Log Getir</button>
				</td>
			</tr>
		</table>


		<c:choose>
			<c:when test="${empty log}">
				<h3>Log Bulunamadi.</h3>
				<button type="button" onclick="window.location = 'menu.jsp'">
					Geri</button>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<th>Nesne Tip</th>
						<th>Islem Tip</th>
						<th>User</th>
						<th>Tarih</th>
					</tr>
					<c:forEach items="${log}" var="mesaj" varStatus="m">

						<tr>
							<td>${log.entityType}</td>
							<td>${log.operationType}</td>
							<td>${log.user.username}</td>
							<td><fmt:formatDate value="${log.date}"
									pattern="dd/MM/yyyy HH:mm:ss" /></td>

						</tr>

					</c:forEach>
					<tr>
						<td>
							<button type="button" onclick="window.location = 'menu.jsp'">GERİ</button>
						</td>

					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</form:form>

	${mesaj}

</body>
</html>

















