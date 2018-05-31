<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="n-head">
    <div class="g-doc f-cb">
        <ul class="nav">
            <li><a href="<c:url value="/"/>">首页</a></li>
            <c:if test="${empty sessionScope.spitter}">
                <li><a href="<c:url value="/login" />">登录</a></li>
                <li><a href="<c:url value="/register"/>">注册</a></li>
            </c:if>
            <c:if test="${!empty sessionScope.spitter}">
                <li><a href="<c:url value="/${sessionScope.spitter.nickname}" />">个人主页</a></li>
                <li><a href="<c:url value="/logout"/>">退出</a></li>
            </c:if>

    </ul>
    </div>
</div>
