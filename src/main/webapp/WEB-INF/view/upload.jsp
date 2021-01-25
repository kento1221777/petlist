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


	<form:form action="" method="post" modelAttribute="pet"
		enctype="multipart/form-data">
		<p>
			ファイル：
			<form:input type="file" path="upfile" />
		</p>

		<p>
			カテゴリ：
			<form:select path="category.id" items="${categoryList}"
						 itemValue="id" itemLabel="categoryName" />
		</p>

		<input type="submit" />

	</form:form>

	<img id="preview" width="500px">

<script src="${js}/jquery-3.5.1.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>

<script>

$(function(){
  $("[name='upfile']").on('change', function (e) {

    var reader = new FileReader();

    reader.onload = function (e) {
        $("#preview").attr('src', e.target.result);
    }

    reader.readAsDataURL(e.target.files[0]);

  });
});
</script>

</body>
</html>