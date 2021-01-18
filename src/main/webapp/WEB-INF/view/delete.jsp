<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>Insert title here</title>
</head>
<body>

	<h1>以下の情報を削除します</h1>

	<img class="img-thumbnail"
		src="${uploads}/<c:out value="${pet.image}" />">
	<c:out value="${pet.petName}" />
	<c:out value="${pet.comment}" />

	<form action="" method="post">
		<div class="button">
			<button type="submit" name="cancel" class="btn btn-primary">キャンセル</button>
			<button type="submit" name="delete" id="delete"
				class="btn btn-danger">削除</button>
		</div>
	</form>


	<script src="${js}/jquery-3.5.1.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>

</body>
</html>