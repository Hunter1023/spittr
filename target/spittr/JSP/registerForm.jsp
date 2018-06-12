<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<%@ include file="include/header.jsp" %>


<br>
<!-- 表单没有设置action属性，会提交到当前路径下；
modelAttribute用于绑定模型对象（对象在Controller中创建）;
 enctype="multipart/form-data" 以multipart数据的形式提交表单，而不是以表单数据的形式进行提交-->
<sf:form cssClass="form-horizontal" id="register" method="post"
         modelAttribute="spitter" enctype="multipart/form-data">
    <div class="form-group">
            <label class="col-md-1 col-md-offset-4 control-label">用户名：</label>
            <!-- sf:input渲染成的html的type=text ,path属性值会渲染成value值 -->
        <div class="col-md-2">
            <sf:input cssClass="form-control" path="username"/>
            <sf:errors path="username"/>
        </div>
        <div class="col-md-2" id="usernameError">

        </div>
    </div>
    <div class="form-group">
        <label class="col-md-1 col-md-offset-4 control-label">密码：</label>
        <div class="col-md-2">
            <sf:password cssClass="form-control" path="password"/>
            <sf:errors path="password"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-md-1 col-md-offset-4 control-label">昵称：</label>
        <div class="col-md-2">
            <sf:input cssClass="form-control" path="nickname"/>
            <sf:errors path="nickname"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-1 col-md-offset-4 control-label">邮箱：</label>
        <div class="col-md-2">
            <sf:input cssClass="form-control" path="email" type="email" />
            <sf:errors path="email"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-1 col-md-offset-4 control-label">上传头像：</label>
        <div class="col-md-1">
            <input type="file" name="icon" accept="image/jpeg,image/png,image/gif"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-2 col-md-offset-5">
            <input type="submit" class="btn btn-primary btn-block" value="注册"/>
        </div>
    </div>
</sf:form>

<%@ include file="include/footer.jsp" %>
</body>

<script type="text/javascript">
    $(function () {
        $(":input[name='username']").change(function () {
            var val = $(this).val();
            val = $.trim(val);

            if(val != ""){
                var url = "${pageContext.request.contextPath}/validateUsername";
                var args = {"username": val, "time": new Date()};

                $.post(url, args, function (data) {
                    $("#usernameError").html(data);
                });
            }
        });
    })
</script>

</html>
