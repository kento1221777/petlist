<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
<h1>一覧</h1>
<p><a href="upload">投稿</a></p>
<p><a href="logout">ログアウト</a></p>

<!-- 画像の表示 -->
	<div class="row">
		<c:forEach items="${files}" var="file">
			<div class="col-12 col-md-3">
				<img class="img-thumbnail" src="uploads/<c:out value="${file.name}" />">
			</div>
		</c:forEach>
	</div>

<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>