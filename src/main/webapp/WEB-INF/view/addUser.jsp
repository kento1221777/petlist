<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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


	<form:form action="" method="post" modelAttribute="user">

		<p>
			名前：
			<form:input path="name" />
		</p>
		<p>
			ログインID：
			<form:input path="loginId" />
		</p>
		<p>
			パスワード：
			<form:input path="loginPass" />
		</p>

		<input type="submit" />

	</form:form>



<script src="${js}/jquery-3.5.1.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>

<script>

</script>

</body>
</html>