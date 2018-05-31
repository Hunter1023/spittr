<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <%@ include file="include/head.jsp"%>
    <body>
    <%@ include file="include/header.jsp" %>
        <h1>个人中心</h1>
        <div>
            头像：<img src="${spitter.headIcon}" alt="头像" width="50px" >
        </div>
        <div>
            昵称：<c:out value="${nickname}" />
        </div>
        <div>
            <c:if test="${sessionScope.spitter.nickname == nickname}">
                邮箱： <c:out value="${spitter.email}" />
            </c:if>
        </div>

        <%@ include file="include/footer.jsp"%>
    </body>
</html>
