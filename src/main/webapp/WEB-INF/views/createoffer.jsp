<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2025-03-20
  Time: 오후 7:44
  이 파일은 사용자로부터 제안을 입력받기 위한 폼 JSP입니다.
--%>

<!-- JSP 페이지 설정: UTF-8 인코딩, Java 언어 사용 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Spring Form 태그 라이브러리 사용 선언 -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Title</title>

  <!-- 정적 리소스(CSS) 경로 설정 -->
  <!-- contextPath는 프로젝트 루트 경로를 의미함 -->
  <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/resources/css/main.css" >
</head>

<body>

<!-- Spring form 태그: form 객체를 바인딩하여 데이터 처리 -->
<!-- method="post"는 서버로 데이터를 전송하는 방식 -->
<!-- action은 폼 전송 시 호출될 컨트롤러의 URL -->
<!-- modelAttribute="offer"는 컨트롤러에서 전달된 모델 객체와 매핑됨 -->
<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">

  <table class="formtable">
    <!-- 이름 입력 필드 -->
    <tr>
      <td class="label"> Name:</td>
      <td>
        <!-- 사용자 입력값을 name 필드에 바인딩 -->
        <sf:input class="control" type="text" path="name"/> <br/>
        <!-- name 필드에 대한 에러 메시지 출력 -->
        <sf:errors path="name" class="error"/>
      </td>
    </tr>

    <!-- 이메일 입력 필드 -->
    <tr>
      <td class="label"> Email:</td>
      <td>
        <sf:input class="control" type="text" path="email"/> <br/>
        <sf:errors path="email" class="error"/>
      </td>
    </tr>

    <!-- 제안 텍스트 입력 필드 -->
    <tr>
      <td class="label"> Offer:</td>
      <td>
        <sf:textarea class="control" rows="10" cols="10" path="text"></sf:textarea> <br/>
        <sf:errors path="text" class="error"/>
      </td>
    </tr>

    <!-- 제출 버튼 -->
    <tr>
      <td></td>
      <td><input type="submit" value="새 제안"/> </td>
    </tr>
  </table>
</sf:form>

</body>
</html>