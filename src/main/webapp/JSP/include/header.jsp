<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="container-fluid modal-header">
    <div class="row">
        <div class="col-md-4">Spittr</div>
        <div class="col-md-4 col-md-offset-4 text-right">
            <span>
                <a href="<c:url value="/"/>">
                    <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                    首页
                </a>
            </span>
            <c:if test="${empty sessionScope.spitter}">
                <span>
                    <a href="<c:url value="/login" />">登录</a>
                </span>
                <span><a href="<c:url value="/register"/>">注册</a></span>
            </c:if>
            <c:if test="${!empty sessionScope.spitter}">
                <span>
                    <a href="<c:url value="/${sessionScope.spitter.nickname}" />">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        ${sessionScope.spitter.nickname}
                    </a>
                </span>
                <span>
                    <a href="<c:url value="/logout"/>">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        退出
                    </a>
                </span>
            </c:if>
        </div>

    </div>
</div>
