<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Kütüphane | Yeni Kullanıcı Sayfası </title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/datepicker3.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
</head>
<body>
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Kullanıcı Kaydı Sayfası</div>
				<div class="panel-body">
					<form:form role="form" action="register" method="post">
						<fieldset>
							<div class="form-group">
								<form:input path="username" class="form-control" placeholder="Kullanıcı Adı" name="username" autofocus/>
							</div>
							<div class="form-group">
								<form:input path="password" class="form-control" placeholder="Şifre" name="password" type="password"/>
							</div>
							<div class="form-group">
								<form:input path="passwordagain" class="form-control" placeholder="Şifre Tekrarı" name="passwordagain" type="password"/>
							</div>
							<div class="row">
								<div class="col-md-6" style="text-align:center;">
									<a href="" class="btn btn-block btn-primary">Kaydı Tamamla</a>
								</div>
								<div class="col-md-6" style="text-align:center;">
									<a href="login.jsp" class="btn btn btn-block btn-success">Giriş Sayfasına Dön</a>
								</div> 
							</div>
						</fieldset>
					</form:form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	
</body>
</html>