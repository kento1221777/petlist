<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/uploads" var="uploads" />
<spring:url value="/css" var="css" />
<spring:url value="/js" var="js" />
<spring:url value="/home/detail" var="detail" />
<spring:url value="/home" var="home" />
<spring:url value="/logout" var="logout" />
<spring:url value="/add" var="add" />
<spring:url value="/home/mygallery" var="mygallery" />
<spring:url value="/home/like" var="like" />
<spring:url value="/delete" var="delete" />

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.7.1/css/lightbox.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.7.1/js/lightbox.min.js" type="text/javascript"></script>
<title>PhotoPet | マイギャラリー</title>
</head>
<body class="home" style="padding-bottom:4.5rem;">
	<div class="container">

		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">PhotoPet</a>
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="ナビゲーションの切替">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item active"><a class="nav-link" href="${home}">ホーム</a></li>
						<li class="nav-item"><a class="nav-link" href="${add}/<c:out value="${id} "/>">投稿</a></li>
						<li class="nav-item"><a class="nav-link" href="${mygallery}/<c:out value="${id} "/>">マイギャラリー</a></li>
						<li class="nav-item"><a class="nav-link" href="${like}/<c:out value="${id} "/>">お気に入り一覧</a></li>
						<li class="nav-item"><a class="nav-link" href="${logout}">ログアウト</a></li>

					</ul>
				</div>
			</nav>
		</header>
		<h1>
			<c:out value="${name}" />
			投稿一覧
		</h1>

		<!-- 画像の表示 -->
		<div class="row petimagelist">
			<c:forEach items="${petList}" var="pet">
				<div class="col-md-3 col-sm-4 col-xs-6">

					<a href="${uploads}/<c:out value="${pet.image}" />" data-lightbox="group">
					<img class="img-thumbnail" src="${uploads}/<c:out value="${pet.image}" />" width="300">
					</a>
					<button
						onclick="location.href='${delete}/<c:out value="${pet.id}" />'"
						type="button" class="btn btn-danger">削除</button>

				</div>
			</c:forEach>
		</div>

	</div>

		<script src="${js}/jquery-3.5.1.min.js"></script>
		<script src="${js}/bootstrap.min.js"></script>
</body>
</html>
