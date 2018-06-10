<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<%@ include file="include/header.jsp" %>

<div class="container">
    <br>
    <%--头像在后端已经做了大小的处理，因此不用设置宽高等属性--%>
    <div class="row">
        <img src="${spitter.headIcon}" alt="头像"
             class="img-responsive center-block img-thumbnail" id="updateIcon">
    </div>

    <div class="row">
        <div class="col-md-offset-5 col-md-2 text-center">
            <c:out value="${nickname}"/><br>
        </div>
    </div>

    <br>
    <div class="col-md-offset-3">
        <c:forEach items="${pageInfo.list}" var="spittle">
            <div class="row">
                <div class="col-md-1">
                    <img src="${spittle.thumbnail}" class="img-responsive img-circle">
                </div>
                <div class="col-md-7">
                    <div class="nickname">
                        <c:out value="${spittle.nickname}"/>
                    </div>
                    <div class="time">
                        <fmt:formatDate value="${spittle.time}" pattern="yyyy-M-d HH:mm"/>
                    </div>
                    <div class="spittleMessage">
                        <c:out value="${spittle.message}"/>
                    </div>
                    <br/><br/>
                </div>
            </div>
        </c:forEach>
    </div>

    <%--分页信息--%>
    <div class="row">
        <%--分页条--%>
        <div class="text-center">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="?pageNum=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                        <c:if test="${pageNum == pageInfo.pageNum}">
                            <li class="active"><a href="#">${pageNum}</a></li>
                        </c:if>
                        <c:if test="${pageNum != pageInfo.pageNum}">
                            <li><a href="?pageNum=${pageNum}">${pageNum}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="?pageNum=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="?pageNum=${pageInfo.pages}">尾页</a></li>
                </ul>
            </nav>
        </div>
    </div>

</div>

<%@ include file="include/footer.jsp" %>
</body>
</html>
