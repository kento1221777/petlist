<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img class="img-thumbnail" src="uploads/<c:out value="${pet.image}" />">
<c:out value="${pet.petName}" />
<c:out value="${pet.comment}" />
<c:out value="${pet.category}" />
<c:out value="${pet.category.categoryName}" />
</body>
</html>