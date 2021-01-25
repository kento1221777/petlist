<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/uploads" var="uploads" />
<spring:url value="/css" var="css" />
<spring:url value="/js" var="js" />
<spring:url value="/home/detail" var="detail" />

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/style.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.7.1/css/lightbox.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.7.1/js/lightbox.min.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>
		<c:out value="${name}" />
		お気に入り一覧
	</h1>

	<!-- 画像の表示 -->
	<div class="row">
		<c:forEach items="${petList}" var="pet">
			<div class="col-12 col-md-3 col-sm-4 col-xs-6">
				<a href="${uploads}/<c:out value="${pet.image}" />" data-lightbox="group">
					<img class="img-thumbnail" src="${uploads}/<c:out value="${pet.image}" />" width="300">
				</a>

			</div>
		</c:forEach>
	</div>


	<script src="${js}/jquery-3.5.1.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>
