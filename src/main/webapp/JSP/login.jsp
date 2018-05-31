<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<%@ include file="include/header.jsp" %>

<sf:form class="m-form m-form-ht n-login" id="login" method="post"
         modelAttribute="spitter" enctype="multipart/form-data">
    <div class="fmitem">
        <div class="fmipt">
            <!-- sf:input渲染成的html的type=text ,path属性值会渲染成value值 -->
            <sf:input path="username" placeholder="输入用户账号/邮箱/手机号"/><br/>
            <sf:errors path="username"/>
        </div>
    </div>
    <div class="fmitem">
        <div class="fmipt">
            <sf:password path="password" placeholder="输入密码"/><br/>
            <sf:errors path="password"/>
        </div>
    </div>
    <div class="fmitem" align="right">
            <c:if test="${!empty msg}">
                ${msg}
            </c:if>
    </div>

    <div class="fmitem ">
        <div class="fmipt">
            <input type="submit" class="u-btn u-btn-primary u-btn-lg u-btn-block" value="登录"/>
        </div>
    </div>
</sf:form>

<%@ include file="include/footer.jsp" %>

</body>
</html>
