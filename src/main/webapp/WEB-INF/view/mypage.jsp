<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/uploads" var="uploads" />
<spring:url value="/css" var="css" />
<spring:url value="/js" var="js" />
<spring:url value="/logout" var="logout" />
<spring:url value="/add" var="add" />
<spring:url value="/home/detail" var="detail" />
<spring:url value="/home" var="home" />


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/style.css">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<c:out value="${name}" />
		投稿一覧
	</h1>


	<p>
		<a href="${add}/<c:out value="${id} "/>">投稿</a>
	</p>
	<p>
		<a href="${logout}">ログアウト</a>
	</p>
	<p>
		<a href="${home}/like/<c:out value="${id} "/>">お気に入り一覧</a>
	</p>



	<!-- 画像の表示 -->
	<div class="row">
		<c:forEach items="${petList}" var="pet">
			<div class="col-12 col-md-3">
				<a href="${detail}/<c:out value="${pet.id}" />">
				<img class="img-thumbnail"
					 src="${uploads}/<c:out value="${pet.image}" />">
				</a>
			</div>
			<td>
				<button
					onclick="location.href='edit/<c:out value="${pet.id}" />'"
					type="button" class="btn btn-primary">編集</button>
			</td>
			<td>
				<button
					onclick="location.href='delete/<c:out value="${pet.id}" />'"
					type="button" class="btn btn-danger">削除</button>
			</td>

		</c:forEach>
	</div>


	<script src="${js}/jquery-3.5.1.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>
