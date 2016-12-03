<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Kütüphane | Anasayfa</title>
	
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
