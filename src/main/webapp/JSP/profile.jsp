<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<%@ include file="include/header.jsp" %>
<div>
    <tr>
        <h1>个人中心</h1>
    </tr>

    <tr>
        <td>头像：</td>
        <%--头像在后端已经做了大小的处理，因此不用设置宽高等属性--%>
        <td><img src="${spitter.headIcon}" alt="头像"></td>
        <br/>
    </tr>

    <tr>
        <td>昵称：</td>
        <td><c:out value="${nickname}"/></td>
    </tr>

    <div>
        <c:if test="${sessionScope.spitter.nickname == nickname}">
            邮箱： <c:out value="${spitter.email}"/>
        </c:if>
    </div>
</div>
<br/><br/>

<div>
    <c:forEach items="${pageInfo.list}" var="spittle">
        <div>
            <img src="${spittle.thumbnail}">
        </div>
        <div>
            <span class="nickname">
                <c:out value="${spittle.nickname}"/>
            </span>
        </div>
        <div>
            <span class="spittleTime">
            <fmt:formatDate value="${spittle.time}" pattern="yyyy-M-d HH:mm"/>
            </span>
        </div>
        <div class="spittleMessage">
            <c:out value="${spittle.message}"/>
        </div>
        <br/><br/>

    </c:forEach>
</div>

<%--分页信息--%>
<div class="row">
    <div class="col-md-offset-3 col-md-3">
        已发布${pageInfo.total}条微博
    </div>
    <%--分页条--%>
    <div class="col-md-6">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li><a href="#">首页</a></li>
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                    <c:if test="${pageNum == pageInfo.pageNum}">
                        <li class="active"><a href="#">${pageNum}</a></li>
                    </c:if>
                    <c:if test="${pageNum != pageInfo.pageNum}">
                        <li><a href="#">${pageNum}</a></li>
                    </c:if>
                </c:forEach>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <li><a href="#">尾页</a></li>
            </ul>
        </nav>
    </div>
</div>

<%@ include file="include/footer.jsp" %>
</body>
</html>
