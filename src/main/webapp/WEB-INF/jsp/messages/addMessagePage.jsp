<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert data</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>

<div class="container">

<p />

<div class="card">
  <div class="card-header">
   新增訊息
  </div>
  <div class="card-body">
   
   <form:form action="${contextRoot}/messages/post" method="post" modelAttribute="messages">
    
   <div class="input-group">
      <form:textarea class="form-control" path="text"/>
   </div>
   <br />
    <button type="submit" class="btn btn-primary mb-2">送出</button>
<!--      <input type="submit" name="submit" value="送出" /> -->
   </form:form>
   
  </div>
</div>




<div class="card">
  <div class="card-header">
  最新訊息 時間: 
  <span><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${lastestMsg.added}"/>   </span>
  <span> </span>
  </div>
  <div class="card-body">
   
   ${lastestMsg.text}
   
  </div>
</div>

</div>


</body>
</html>