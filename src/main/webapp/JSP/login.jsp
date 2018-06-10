<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<%@ include file="include/header.jsp" %>

<br>
<sf:form cssClass="form-horizontal" id="login" method="post"
         modelAttribute="spitter" enctype="multipart/form-data">
    <div class="form-group">
        <div class="col-md-2 col-md-offset-5">
            <!-- sf:input渲染成的html的type=text ,path属性值会渲染成value值 -->
            <sf:input cssClass="form-control" path="username" placeholder="输入用户账号/邮箱/手机号"/>
            <sf:errors path="username"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-2 col-md-offset-5">
            <sf:password cssClass="form-control" path="password" placeholder="输入密码"/>
            <sf:errors path="password"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-2 col-md-offset-5">
            <c:if test="${!empty msg}">
                ${msg}
            </c:if>
        </div>
    </div>
    <div class="form-group ">
        <div class="col-md-2 col-md-offset-5">
            <input type="submit" class="btn btn-primary btn-block" value="登录"/>
        </div>
    </div>
</sf:form>

<%@ include file="include/footer.jsp" %>

</body>
</html>
