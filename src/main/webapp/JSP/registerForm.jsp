<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
    <%@ include file="include/head.jsp"%>
    <body>
        <%@ include file="include/header.jsp"%>

        <!-- 表单没有设置action属性，会提交到当前路径下；modelAttribute用于绑定模型对象（对象在Controller中创建） -->
        <sf:form class="m-form m-form-ht n-login" id="loginForm" method="post" modelAttribute="spitter">
            <div class="fmitem">
                <label class="fmlab">用户名：</label>
                <div class="fmipt">
                    <!-- sf:input渲染成的html的type=text ,path属性值会渲染成value值 -->
                    <sf:input path="username" /><sf:errors path="username" />
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">密码：</label>
                <div class="fmipt">
                    <sf:password path="password" /><sf:errors path="password" />
                </div>
            </div>
            <div class="fmitem">
                <label class="fmlab">邮箱：</label>
                <div class="fmipt">
                    <sf:input path="email" type="email"/><sf:errors path="email" />
                </div>
            </div>
            <div class="fmitem fmitem-nolab fmitem-btn">
                <div class="fmipt">
                    <input type="submit" class="u-btn u-btn-primary u-btn-lg u-btn-block" value="注册" />
                </div>
            </div>
        </sf:form>

        <%@ include file="include/footer.jsp"%>
    </body>
</html>
