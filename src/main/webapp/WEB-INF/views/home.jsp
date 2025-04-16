<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <!-- 현재 애플리케이션의 컨텍스트 경로를 기준으로 /offers 페이지로 이동하는 링크 생성 -->
  <p>
    <a href="${pageContext.request.contextPath}/offers"> Show current offers</a>
  </p>

  <!-- 현재 애플리케이션의 컨텍스트 경로를 기준으로 /createoffer 페이지로 이동하는 링크 생성 -->
  <p>
    <a href="${pageContext.request.contextPath}/createoffer"> Add a new offer</a>
  </p>
  </body>
</html>
