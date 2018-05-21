<%--
  Created by IntelliJ IDEA.
  User: Hunter
  Date: 2018/5/16
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <%@ include file="include/head.jsp"%>
    <body>
        <h1>个人中心</h1>
        头像：
        用户名：<c:out value="${spitter.username}" />
        邮箱： <c:out value="${spitter.email}" />
        <%@ include file="include/footer.jsp"%>
    </body>
</html>
