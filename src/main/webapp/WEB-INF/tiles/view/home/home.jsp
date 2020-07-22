<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Spring MVC Internationalization i18n Example</title>

    <link rel="stylesheet" href="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css" />

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>

</head>
<body>

<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" >
	<ol class="carousel-indicators">
		<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img src="../../../../img/code-wallpaper-1.png" height="80%" class="d-block w-100" alt="...">
		</div>
		<div class="carousel-item">
			<img  src="../../../../img/code-wallpaper-2.png" height="80%"  class="d-block w-100" alt="...">
		</div>
		<div class="carousel-item">
			<img  src="../../../../img/code-wallpaper-3.png" height="80%"  class="d-block w-100" alt="...">
		</div>
	</div>


	<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		<span class="carousel-control-prev-icon" aria-hidden="true"></span>
		<span class="sr-only">Previous</span>
	</a>
	<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		<span class="carousel-control-next-icon" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
	</a>
</div>


</body>

</html>
