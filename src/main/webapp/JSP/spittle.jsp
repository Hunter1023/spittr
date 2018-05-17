<%--
  Created by IntelliJ IDEA.
  User: Hunter
  Date: 2018/5/16
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
    <%@ include file="include/head.jsp"%>
    <body>
        <div class="spittleView">
            <div class="spittleMessage">
                <c:out value="${spittle.message}"/>
            </div>
            <div>
                <span class="spittleTime">
                    <c:out value="${spittle.time}"/>
                </span>
            </div>
        </div>

        <%@ include file="include/footer.jsp"%>
    </body>
</html>
