<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSTL core 라이브러리(c:)를 사용하기 위한 선언 -->

<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2025-03-14
  Time: 오후 5:39
  해당 JSP 파일은 컨트롤러에서 전달한 offer 리스트를 반복 출력하는 용도
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>  <!-- 브라우저 탭에 표시될 제목 -->
</head>
<body>

<!--
    컨트롤러에서 모델에 담아 전달한 리스트(id_offers)를 반복 출력
    각각의 요소를 offer 변수에 담아 아래 블록에서 사용함
 -->
<c:forEach var="offer" items="${id_offers}">
    <!--
    offer 객체를 문자열로 출력함.
    내부적으로 toString() 메서드가 호출되며, HTML 이스케이프 처리도 자동 수행됨
    -->
    <p><c:out value="${offer}" /></p>
</c:forEach>

</body>
</html>