<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhotoPet | ログイン画面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="text-center mt-4">
<h1>ログイン画面</h1>

	<a href="addUser">新規会員登録</a>


	<form:form class="mt-4" action="" method="post" modelAttribute="user">
		<form:errors path="loginId" cssClass="error" />
		<p class="mt-2">ログインID：<form:input path="loginId" /></p>

		<form:errors path="loginPass" cssClass="error" />
		<p>パスワード：<form:password path="loginPass" /></p>
		<input class="btn btn-primary" type="submit" value="ログイン">
	</form:form>

</div>
</body>
</html>