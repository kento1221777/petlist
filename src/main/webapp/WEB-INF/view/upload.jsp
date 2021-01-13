<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
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
			名前：
			<form:input path="petName" />
		</p>
		<p>
			コメント
			<form:textarea path="comment" />
		</p>

		<p>
			カテゴリ：
			<form:select path="category.id" items="${categoryList}"
						 itemValue="id" itemLabel="categoryName" />
		</p>

		<input type="submit" />

	</form:form>


</body>
</html>