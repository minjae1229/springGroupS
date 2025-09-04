<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>xmlTest5.jsp</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<p><br/></p>
	<div class="container">
		<h2>비만도 bmi 측정</h2>
	
		<table border="1" class="table table-hover text-center">
    <tr class="table-secondary">
        <th>번호</th>
        <th>이름</th>
        <th>키(cm)</th>
        <th>몸무게(kg)</th>
        <th>BMI</th>
        <th>비만도</th>
    </tr>
    <c:forEach var="vo" items="${vos}" varStatus="st">
    	<tr>
    		<td>${st.count}</td>
        <td>${vo.name}</td>
        <td>${vo.height}</td>
        <td>${vo.weight}</td>
        <td>${vo.bmi}</td>
        <td>${vo.result}</td>
      </tr>
    </c:forEach>
</table>
		
		<p class="text-center"><a href="xmlMenu" class="btn btn-success">돌아가기</a></p>
	</div>
<p><br/></p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>