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
