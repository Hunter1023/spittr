<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sf:form cssClass="form-horizontal" method="post" modelAttribute="spitter">
    <div class="form-group">
        <label class="col-md-1 col-md-offset-4 control-label">用户名：</label>
        <div class="col-md-2">
            <sf:input cssClass="form-control" path="username"/>
            <sf:errors path="username"/>
        </div>
    </div>
</sf:form>