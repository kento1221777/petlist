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
	<form action="" method="post" enctype="multipart/form-data"
		name="form">
		<p>
			ファイル：<input type="file" name="upfile" id="upfile">
			<input type="submit">
		</p>
	</form>


</body>
</html>