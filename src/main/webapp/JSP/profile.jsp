<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <%@ include file="include/head.jsp"%>
    <body>
    <%@ include file="include/header.jsp" %>
        <div>
            <tr>
                <h1>个人中心</h1>
            </tr>

            <tr>
                <td>头像：</td>
                <td><img src="${spitter.headIcon}" alt="头像" width="50px"></td><br/>
            </tr>

            <tr>
                <td>昵称：</td>
                <td> <c:out value="${nickname}" /></td>
            </tr>

            <div>
                <c:if test="${sessionScope.spitter.nickname == nickname}">
                    邮箱： <c:out value="${spitter.email}" />
                </c:if>
            </div>

        </div>


        <%@ include file="include/footer.jsp"%>
    </body>
</html>
