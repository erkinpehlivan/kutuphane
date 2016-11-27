<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
    pageEncoding="ISO-8859-9"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Kütüphane | Anasayfa</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/bootstrap-table.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!--Icons-->
<script src="js/lumino.glyphs.js"></script>

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Menüyü Kapat</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>EGM</span>KÜTÜPHANE</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Kullanýcý Adý <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Çýkýþ Yap </a></li>
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
			<!-- Eðer Kullanýcýysa -->
			<li  class="active"><a href="#"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Kitap Rezerve Et</a></li>
			<!-- Eðer Admin ise -->
			<li><a href="#"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Yazar Ýþlemleri</a></li>
			<li><a href="#"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Kitap Ýþlemleri</a></li>
			<li><a href="#"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Rapor Al</a></li>
			<li role="presentation" class="divider"></li>
			<li><a href="#"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Parola Güncelle</a></li>
		</ul>

	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Kitap Rezerve Et</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Kitap Rezerve Et</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Kitap Listesi</div>
					<div class="panel-body">
						<table data-toggle="table">
						    <thead>
						    <tr>
						        <th data-field="sn" data-align="center">SN</th>
						        <th data-field="kitapAdi">Kitap Adý</th>
						        <th data-field="kategori">Kitap Kategorisi</th>
						        <th data-field="isbn">ISBN</th>
						        <th data-field="islem" data-align="center">Ýþlem</th>
						    </tr>
						    </thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Kim Korkar Javadan</td>
									<td>Eðitim</td>
									<td>145321373</td>
									<td>
									<a href="#" type="submit" class="btn btn-primary">Rezerve Et</a>
									</td>
								</tr>
								<tr>
									<td>1</td>
									<td>Kim Korkar Javadan</td>
									<td>Eðitim</td>
									<td>145321373</td>
									<td>
									<a href="#" type="submit" class="btn btn-primary">Rezerve Et</a>
									</td>
								</tr>
								<tr>
									<td>1</td>
									<td>Kim Korkar Javadan</td>
									<td>Eðitim</td>
									<td>145321373</td>
									<td>
									<a href="#" type="submit" class="btn btn-primary">Rezerve Et</a>
									</td>
								</tr>
								<tr>
									<td>1</td>
									<td>Kim Korkar Javadan</td>
									<td>Eðitim</td>
									<td>145321373</td>
									<td>
									<a href="#" type="submit" class="btn btn-primary">Rezerve Et</a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
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
