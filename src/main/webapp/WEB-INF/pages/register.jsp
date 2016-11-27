<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>K�t�phane | Yeni Kullan�c� Sayfas� </title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Kullan�c� Kayd� Sayfas�</div>
				<div class="panel-body">
					<form role="form">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Kullan�c� Ad�" name="kullaniciAdi" autofocus>
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="�ifre" name="password" type="password">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="�ifre Tekrar�" name="passwordAgain" type="password">
							</div>
							<div class="row">
								<div class="col-md-6" style="text-align:center;">
									<a href="" class="btn btn-block btn-primary">Kayd� Tamamla</a>
								</div>
								<div class="col-md-6" style="text-align:center;">
									<a href="" class="btn btn btn-block btn-success">Giri� Sayfas�na D�n</a>
								</div> 
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	
</body>
</html>