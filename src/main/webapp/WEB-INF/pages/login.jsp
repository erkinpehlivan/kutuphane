<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>K�t�phane | Giri� Sayfas�</title>
<style type="text/css">
.error {
	margin: 10px 0px;
	padding: 12px;
}

.error {
	color: #D8000C;
	background-color: #FFBABA;
	vertical-align: middle;
}

.error i {
	margin: 10px 22px;
	font-size: 2em;
	vertical-align: middle;
}

body {
	background-color: silver;
}
</style>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/datepicker3.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome-min.css" />"
	rel="stylesheet">
</head>
<body>
	<c:if test="${not empty hata}">
		<div class="error" align="center">
			<i class="fa fa-times-circle"></i> <br />
			Giri� Yapamazs�n�z !!!<br />
			Yetkiniz yoktur !!! <br />
		</div>
	</c:if>
	<div class="row">
		<div
			class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">K�t�phane Projesi Giri� Sayfas�</div>
				<div class="panel-body">
					<form role="form" action="giris_kontrol" method="post">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Kullan�c� Ad�"
									name="username" autofocus>
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="�ifre" name="password"
									type="password">
							</div>
							<div class="row">
								<div class="col-md-6" style="text-align: center;">
									<!-- 									<a href="" class="btn btn btn-block btn-success">Giri� Yap</a> -->
									<button class="btn btn btn-block btn-success" type="submit">Giri�
										Yap</button>
								</div>
								<div class="col-md-6" style="text-align: center;">
									<a href="reg.html" class="btn btn-block btn-primary">Kay�t
										Ol</a>
								</div>
							</div>
						</fieldset>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</div>
			</div>
		</div>
		<!-- /.col-->
	</div>
	<!-- /.row -->
</body>
</html>