<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"> 
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>aopMenu.jsp</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<p><br/></p>
	<div class="container">
		<h2>Service 객체를 활용한 AOP 연습</h2>
		<hr/>
		<p>
			<a href="test1" class="btn btn-success me-2">연습1</a>
			<a href="test2" class="btn btn-primary me-2">연습2</a>
			<a href="test3" class="btn btn-secondary me-2">연습3</a>
			<a href="test4" class="btn btn-info me-2">연습4</a>
		</p>
		<hr/>
		<h2>AOP : 문제를 바라보는 관점을 기준으로 프로그래밍 하는 기법</h2>
		<pre>
		: 핵심(종단)관심사(core consern) : 은행의 입금/출금/대출 등 업무
		: 공통(횡단)관심사(cross-cutting concern) : 로그, 트랜잭션처리, 보안처리 등
		- AOP는 핵심코드를 가지고 있는 클래스(부모)는 건들지 않고, 상속받아 사용하는 자식 클래스에서 override 하여 재사용한다.
		- AOP의 적용은 Spring 런타임시에 proxy를 이용하여 적용한다(위빙,weaving)
		
		- AOP 용어 :
		. target object : 상속받는 부모클래스
		. join point : target object에 있는 처리해야할 모든 method(override해서 사용)
		. point cut : target object에서 실제로 처리할 method(여기에 advice를 적용)
		. advice : target object에서 사용하려 하는 공통코드와 해당 코드가 언제 실행하게 할지에 대해 처리.
			- 5가지 시점 : 
		.advisor : point cut + advice , advice가 적용된 것으로 aspect와 같음
			수행되는 명령어 : before advice, after, after-throwing, after-returning, around
		.weaving : target object안의 override된 method중 핵심코드에 공통코드가 삽입되는 것
		.aspect : AOP의 핵심, 즉 해당 포인트 컷이 어느시점에 수행되게 하는가의 관점을 의미.
		
		</pre>
	</div>
<p><br/></p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>