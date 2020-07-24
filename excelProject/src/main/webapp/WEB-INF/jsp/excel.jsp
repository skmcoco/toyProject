<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Excel Page</title>
</head>
<style>

</style>

<body>
	<table id="tbl">
		
	</table>
	<body>
    <form action="excelUpload.do" method="POST" enctype="multipart/form-data">
      <input type="file" name="file">
      <input type="submit" value="제출"/>
    </form>
  </body>
</body>
</html>

