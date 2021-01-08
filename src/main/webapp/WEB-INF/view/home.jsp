<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/uploads" var="uploads"/>
<spring:url value="/css" var="css" />
<spring:url value="/js" var="js" />
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/style.css">
<title>Insert title here</title>
</head>
<body>
<h1>一覧</h1>
<p><a href="upload">投稿</a></p>
<p><a href="logout">ログアウト</a></p>
<p><a href="/user/gallery/<c:out value="${user.id} "/>">マイギャラリー</a></p>

<c:forEach items="${categoryList}" var="category">
<a href="home/category/<c:out value="${category.id} "/>"> <c:out value="${category.categoryName} "/> </a>
</c:forEach>

<!-- 画像の表示 -->
	<div class="row">
		<c:forEach items="${petList}" var="pet">
			<div class="col-12 col-md-3">
			<a href="home/<c:out value="${pet.id}" />">
				<img class="img-thumbnail" src="${uploads}/<c:out value="${pet.image}" />">
			</a>
			</div>
		</c:forEach>
	</div>

<script src="${js}/jquery-3.5.1.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>
</body>
</html>