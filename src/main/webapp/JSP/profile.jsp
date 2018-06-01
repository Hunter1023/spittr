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
