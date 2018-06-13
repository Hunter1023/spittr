<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<%@ include file="include/header.jsp" %>

<div class="container">
    <br>
    <%--头像在后端已经做了大小的处理，因此不用设置宽高等属性--%>
    <div class="row">
        <div class="col-md-offset-5 col-md-2">
            <div class="thumbnail">
                <img src="${spitter.headIcon}" alt="头像" class="img-responsive" id="updateIcon">
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-offset-5 col-md-2 text-center">
            <h2>
                <c:out value="${nickname}"/><br>
            </h2>
        </div>
        <c:if test="${sessionScope.spitter.nickname} == ${nickname}">
            <div class="col-md-2"></div>
        </c:if>
    </div>
    <br>
    <%--标签页--%>
    <div class="row">
        <div class="col-md-offset-5 col-md-4 ">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">动态</a></li>
                <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">用户信息</a></li>
            </ul>
        </div>
    </div>
    <div class="row">
        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="home">
                <br>
                <%@ include file="include/spittleList.jsp"%>
                <%@ include file="include/paging.jsp"%>
            </div>
            <div role="tabpanel" class="tab-pane " id="settings">
                <br>
                <div class="row">
                    <label class="col-md-2 col-md-offset-5 control-label">
                        用户名：${spitter.username}
                    </label>
                </div>
                <div class="row">
                    <label class="col-md-2 col-md-offset-5 control-label">
                        昵称：${spitter.nickname}
                    </label>
                </div>
                <div class="row">
                    <label class="col-md-2 col-md-offset-5 control-label">
                        邮箱：${spitter.email}
                    </label>
                </div>
            </div>
        </div>
    </div>


</div>

<%@ include file="include/footer.jsp" %>
</body>
</html>
