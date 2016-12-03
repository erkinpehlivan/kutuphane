<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>K�t�phane | �ifre De�i�tir</title>
	
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/datepicker3.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap-table.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

	<!--Icons-->
	<script src="<c:url value="/resources/js/lumino.glyphs.js" />"></script>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Men�y� Kapat</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>EGM</span>K�T�PHANE</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<svg class="glyph stroked male-user">
								<use xlink:href="#stroked-male-user"></use>
							</svg> 
							Kullan�c� Ad� <span class="caret"></span>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">
								<svg class="glyph stroked cancel">
									<use xlink:href="#stroked-cancel"></use>
								</svg> ��k�� Yap </a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Kitap Ara">
			</div>
		</form>
		<ul class="nav menu">
			<li><a href="#"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Ana Sayfa</a></li>
			<!-- E�er Kullan�c�ysa -->
			<li><a href="#"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Kitap Rezerve Et</a></li>
			<!-- E�er Admin ise -->
			<li><a href="#"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Yazar ��lemleri</a></li>
			<li><a href="#"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Kitap ��lemleri</a></li>
			<li><a href="#"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Rapor Al</a></li>
			<li role="presentation" class="divider"></li>
			<li class="active"><a href="#"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Parola G�ncelle</a></li>
		</ul>

	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Parola De�i�tir</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Parola De�i�tir</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="panel panel-default">
			<div class="panel-heading">�ifre De�i�tirme Formu</div>
				<div class="panel-body">
					<form:form modelAttribute="user" role="form" action="changePassword" method="post">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Eski �ifreniz</label>
									<form:input path="password" class="form-control" name="password" type="password"/>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Yeni �ifreniz</label>
									<form:input path="newPassword" class="form-control" name="newPassword" type="password"/>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Yeni �ifre Tekrar�</label>
									<form:input path="newPasswordAgain" class="form-control" name="newPasswordAgain" type="password"/>
								</div>
							</div>
							<div class="col-md-12">
								<button type="submit" class="btn btn-block btn-primary">Parolay� De�i�tir</button>
							</div>
						</div>
					</form:form>
				</div>
		</div><!--/.row-->		
		
	</div><!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script>
		!function ($) {
			$(document).on("click","ul.nav li.parent > a > span.icon", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>
</html>