<%--
  Created by IntelliJ IDEA.
  User: Hunter
  Date: 2018/5/15
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
    <%@ include file="include/head.jsp"%>
    <body>
        <h2>动态列表</h2>
        <c:forEach items="${spittleList}" var="spittle" >
            <li id="spittle_<c:out value="spittle.id"/>">
                <div class="spittleMessage">
                    <c:out value="${spittle.message}"/>
                </div>
                <div>
                    <span class="spittleTime">
                        <c:out value="${spittle.time}"/>
                    </span>
                </div>
            </li>
        </c:forEach>

        <%@ include file="include/footer.jsp"%>
    </body>
</html>
