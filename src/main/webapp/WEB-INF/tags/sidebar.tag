<%@tag description="Side" pageEncoding="UTF-8"%>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Kitap Ara">
			</div>
		</form>
		<ul class="nav menu">
			<li><a href="#"><svg class="glyph stroked dashboard-dial">
						<use xlink:href="#stroked-dashboard-dial"></use></svg> Ana Sayfa</a></li>
			<!-- Eğer Kullanıcıysa -->
			<li class="active"><a href="#"><svg
						class="glyph stroked star">
						<use xlink:href="#stroked-star"></use></svg> Kitap Rezerve Et</a></li>
			<!-- Eğer Admin ise -->
			<li><a href="#"><svg class="glyph stroked star">
						<use xlink:href="#stroked-star"></use></svg> Yazar İşlemleri</a></li>
			<li><a href="#"><svg class="glyph stroked star">
						<use xlink:href="#stroked-star"></use></svg> Kitap İşlemleri</a></li>
			<li><a href="#"><svg class="glyph stroked star">
						<use xlink:href="#stroked-star"></use></svg> Rapor Al</a></li>
			<li role="presentation" class="divider"></li>
			<li><a href="#"><svg class="glyph stroked male-user">
						<use xlink:href="#stroked-male-user"></use></svg> Parola Güncelle</a></li>
		</ul>

	</div>
	<!--/.sidebar-->
