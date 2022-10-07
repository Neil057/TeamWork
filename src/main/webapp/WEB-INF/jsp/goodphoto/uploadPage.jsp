<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Page</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
<div class="container">
   
<h1>圖片上傳</h1>

<h3>${errorMsg}</h3>

<form action="${pageContext.request.contextPath}/uploadPhoto" method="post" enctype="multipart/form-data">
  圖片名稱 : <input id="photoName" name="photoName" />
  <br />
  選擇檔案 : <input type="file" name="file" />
  
  <br />
  
  <input type="submit" value="上傳圖片">

</form>


</div>


</body>
</html>