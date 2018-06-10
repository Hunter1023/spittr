<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<%@ include file="include/head.jsp" %>
<body>
<%@ include file="include/header.jsp" %>
<div id="content">
    <c:if test="${!empty sessionScope.spitter}">
        <div class="publish">
                <%--当前未提供图片发布功能--%>
            <sf:form class="m-form m-form-ht n-login" method="post" modelAttribute="spittle">
                <div class="fmitem">
                    <div class="fmipt">
                        <!-- sf:input渲染成的html的type=text ,path属性值会渲染成value值 -->
                        <sf:textarea path="message" cols="80" rows="5"/>
                        <sf:errors path="message"/>
                    </div>
                </div>
                <div class="fmitem fmitem-nolab fmitem-btn">
                    <div class="fmipt">
                        <input type="submit" class="btn btn-info" value="发布"/>
                    </div>
                </div>
            </sf:form>
        </div>
    </c:if>

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

    <%--分页信息--%>
    <div class="row">
        <%--分页条--%>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="?pageNum=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="?pageNum=${pageNum-1}" aria-label="Previous">
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
                            <a href="?pageNum=${pageNum+1}" aria-label="Next">
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
