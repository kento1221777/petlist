<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/uploads" var="uploads" />
<spring:url value="/css" var="css" />
<spring:url value="/js" var="js" />
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<title>Insert title here</title>
</head>
<body>
	<h1>一覧</h1>
	<p>
		<a href="add/<c:out value="${id} "/>">投稿</a>
	</p>
	<p>
		<a href="logout">ログアウト</a>
	</p>
	<p>
		<c:out value="${name}" />
		さん
	</p>
	<p>
		<a href="home/gallery/<c:out value="${id} "/>">マイギャラリー</a>
	</p>

	<c:forEach items="${categoryList}" var="category">
		<a href="home/category/<c:out value="${category.id} "/>"> <c:out
				value="${category.categoryName} " />
		</a>
	</c:forEach>

	<!-- 画像の表示 -->
	<div class="row">
	<c:out value="${id}" />
		<c:forEach items="${petList}" var="pet">
			<div class="col-12 col-md-3">
				<a href="home/<c:out value="${pet.id}" />"> <img
					class="img-thumbnail"
					src="${uploads}/<c:out value="${pet.image}" />">
				</a>
				<button
					onclick="location.href='home/like/<c:out value="${pet.id}" />/<c:out value="${id}" />'"
					type="button" class="btn btn-primary">いいね
				</button>
			</div>
		</c:forEach>
	</div>

	<script src="${js}/jquery-3.5.1.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>

<script>


</script>
</body>
</html>