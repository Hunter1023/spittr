<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="row">
    <c:forEach items="${pageInfo.list}" var="spittle">
        <div class="col-md-offset-3 col-md-6 panel panel-default">
            <div class="panel-body media">
                <div class="media-left">
                    <a href="${spittle.nickname}">
                        <img src="${spittle.thumbnail}" class="media-object img-circle">
                    </a>
                </div>
                <div class="media-body">
                    <div class="nickname">
                        <c:out value="${spittle.nickname}"/>
                    </div>
                    <div class="time">
                        <fmt:formatDate value="${spittle.time}" pattern="yyyy-M-d HH:mm"/>
                    </div>
                    <div class="spittleMessage">
                        <c:out value="${spittle.message}"/>
                    </div>
                </div>
                <div class="bottom-toolbar">
                    <ul class="nav navbar-nav">
                        <li>
                            <a>
                                <span class="glyphicon glyphicon-share" aria-hidden="true"></span>
                                转发
                            </a>
                        </li>
                        <li>
                            <a>
                                <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                评论
                            </a>

                        </li>
                        <li>
                            <a>
                                <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
                                点赞
                            </a>
                        </li>
                        <c:if test="${!empty sessionScope.spitter}">
                            <c:if test="${spittle.nickname == sessionScope.spitter.nickname}">
                                <li>
                                    <a>
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        删除
                                    </a>
                                </li>
                            </c:if>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
