<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Items Page</title>
</head>
<body>
	<h1>Items Page</h1>
	<c:if test="${empty requestScope.itemInserted}" >
		Just attempted to create an item - 
		${requestScope.itemInserted.name}, 
		${requestScope.itemInserted.description}, 
		${requestScope.itemInserted.createdDate}, 
		${requestScope.itemInserted.price} 
	</c:if>
	<br/>
	<c:if test="${empty requestScope.items}" >
		The query returned ${requestScope.items.size} items.<br/>
	</c:if>
	<c:forEach var="item" items="${requestScope.items}">
		Item: ${item.name} <br/>
	</c:forEach>
	<br/>
	Sum of 2 and 3 is ${requestScope.sum}. <br/>
	Difference of 5 and 2 is ${requestScope.difference}. <br/>
	<br/>
	Does the session exist? <c:out value="${requestScope.sessionExists}"/> <br/>

</body>
</html>
