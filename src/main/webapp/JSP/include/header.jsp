<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/spittr">Spittr</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="输入要查找的内容">
                </div>
                <button type="submit" class="btn btn-default">查找</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<c:url value="/"/>">
                        <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                        首页
                    </a>
                </li>
                <c:if test="${empty sessionScope.spitter}">
                    <li><a href="<c:url value="/login" />">登录</a>
                    </li>
                    <li><a href="<c:url value="/register"/>">注册</a></li>
                </c:if>
                <c:if test="${!empty sessionScope.spitter}">
                    <li>
                        <a href="<c:url value="/${sessionScope.spitter.nickname}" />">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                ${sessionScope.spitter.nickname}
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/logout"/>">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                            退出
                        </a>
                    </li>
                </c:if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
