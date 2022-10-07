<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Messages</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>

<div class="container">
   <h1>Show Messages Page</h1>
   
   <c:forEach var="message" items="${page.content}">
	   <div class="card">
		  <div class="card-header">
		  最新訊息 時間: 
		  <span><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${message.added}"/>   </span>
		  <span> </span>
		  </div>
		  <div class="card-body">
		   
		   ${message.text}
		   
		   <div class="edit-place">
		     <a href="${contextRoot}/messages/edit?id=${message.id}">編輯</a> |
		     <a onclick="return confirm('確定刪除嗎?')" href="${contextRoot}/messages/delete?id=${message.id}">刪除</a>
		   </div>
		  
		  </div>
	  </div>
  </c:forEach>
  
  <c:forEach var="pageNumber" begin="1" end="${page.totalPages}" >
  
  <c:choose>
    <c:when test="${page.number != pageNumber-1}">
      <a href="${contextRoot}/messages/page?p=${pageNumber}">${pageNumber}</a>
    </c:when>
      
    <c:otherwise>
       ${pageNumber}
    </c:otherwise>  
  </c:choose>
  
  <c:if test="${pageNumber !=  page.totalPages}">
  |
  </c:if>
  
  
  </c:forEach>


</div>

</body>
</html>