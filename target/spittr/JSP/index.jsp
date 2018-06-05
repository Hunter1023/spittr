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
            <sf:form class="m-form m-form-ht n-login" id="loginForm"
                     method="post" modelAttribute="spittle">
                <div class="fmitem">
                    <div class="fmipt">
                        <!-- sf:input渲染成的html的type=text ,path属性值会渲染成value值 -->
                        <sf:textarea path="message" cols="80" rows="5"/>
                        <sf:errors path="message"/>
                    </div>
                </div>
                <div class="fmitem fmitem-nolab fmitem-btn">
                    <div class="fmipt">
                        <input type="submit"
                               class="u-btn u-btn-primary u-btn-lg u-btn-block" value="发布"/>
                    </div>
                </div>
            </sf:form>
        </div>
    </c:if>

    <c:forEach items="${spittleList}" var="spittle">
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

<%@ include file="include/footer.jsp" %>
</body>
</html>
