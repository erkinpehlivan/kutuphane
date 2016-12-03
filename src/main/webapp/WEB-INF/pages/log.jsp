<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>K�t�phane | Rapor Al</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/datepicker3.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap-table.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

	<!--Icons-->
	<script src="<c:url value="/resources/js/lumino.glyphs.js" />"></script>
</head>

<body>



<t:navbar>

</t:navbar>
<t:sidebar>

</t:sidebar>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"> <use
							xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Rapor Alr</li>
			</ol>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Rapor Al</h1>
			</div>
		</div>
		<!--/.row-->


		<div class="panel panel-default">
			<div class="panel-heading">Rapor Al</div>
			<div class="panel-body">
				<form:form modelAttribute="user">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label>User Name</label> <input type="text" class="form-control">
							</div>
							<div class="col-md-12">
								<button type="submit" class="btn btn-block btn-primary">Log
									Getir</button>
							</div>
						</div>
					</div>

					<c:choose>
						<c:when test="${empty log}">
							<h3>Log Bulunamadi.</h3>
							<button type="button" onclick="window.location = 'menu.jsp'">
								Geri</button>
						</c:when>
						<c:otherwise>


							<div class="row">
								<div class="col-lg-12">
									<div class="panel panel-default">
										<div class="panel-heading">Rapor Listesi</div>
										<div class="panel-body">
											<table data-toggle="table">
												<thead>
													<tr>
														<th data-field="entityType" data-align="center">Nesne
															Tipi</th>
														<th data-field="operationType">Islem Tipi</th>
														<th data-field="user">Kullanici</th>
														<th data-field="date">Tarih</th>

													</tr>
												</thead>

												<c:forEach items="${log}" var="mesaj" varStatus="m">
													<tbody>
														<tr>
															<td>${log.entityType}</td>
															<td>${log.operationType}</td>
															<td>${log.user.username}</td>
															<td><fmt:formatDate value="${log.date}"
																	pattern="dd/MM/yyyy HH:mm:ss" /></td>

														</tr>
													</tbody>
												</c:forEach>
												<tr>
													<td>
														<button type="button"
															onclick="window.location = 'menu.jsp'">GER�</button>
													</td>

												</tr>

											</table>
										</div>
									</div>
								</div>
							</div>
							<!--/.row-->
						</c:otherwise>
					</c:choose>
				</form:form>
				${mesaj}
			</div>
		</div>
		<!--/.row-->

	</div>
	<!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script>
		!function($) {
			$(document)
					.on(
							"click",
							"ul.nav li.parent > a > span.icon",
							function() {
								$(this).find('em:first').toggleClass(
										"glyphicon-minus");
							});
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function() {
			if ($(window).width() > 768)
				$('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function() {
			if ($(window).width() <= 767)
				$('#sidebar-collapse').collapse('hide')
		})
	</script>
</body>

</html>



