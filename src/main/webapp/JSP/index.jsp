<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<%@ include file="include/head.jsp" %>
<body>
<%@ include file="include/header.jsp" %>

<!-- Modal -->
<div class="modal fade" id="addImgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加图片</h4>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <br>
    <c:if test="${!empty sessionScope.spitter}">
        <sf:form cssClass="form-horizontal" method="post" modelAttribute="spittle">
            <div class="form-group">
                <div class="col-md-offset-3 col-md-6">
                    <!-- sf:input渲染成的html的type=text ,path属性值会渲染成value值 -->
                    <sf:textarea path="message" cssClass="form-control" rows="5"/>
                    <sf:errors path="message"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-3 col-md-5">
                    <span id="addImg" class="glyphicon glyphicon-picture" aria-hidden="true"></span>
                    图片
                </div>
                <div class="col-md-1">
                    <input type="submit" class="btn btn-info btn-block" value="发布"/>
                </div>
            </div>
        </sf:form>
    </c:if>
    <br>

    <div class="col-md-offset-3">
        <c:forEach items="${pageInfo.list}" var="spittle">
            <div class="row">
                <div class="col-md-1">
                    <img src="${spittle.thumbnail}" class="img-responsive img-circle">
                </div>
                <div class="col-md-7">
                    <div class="nickname">
                        <c:out value="${spittle.nickname}"/>
                    </div>
                    <div class="time">
                        <fmt:formatDate value="${spittle.time}" pattern="yyyy-M-d HH:mm"/>
                    </div>
                    <div class="spittleMessage">
                        <c:out value="${spittle.message}"/>
                    </div>
                    <br/><br/>
                </div>
            </div>
        </c:forEach>
    </div>


    <%--分页信息--%>
    <div class="row">
        <%--分页条--%>
        <div class="text-center">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="?pageNum=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                        <c:if test="${pageNum == pageInfo.pageNum}">
                            <li class="active"><a href="#">${pageNum}</a></li>
                        </c:if>
                        <c:if test="${pageNum != pageInfo.pageNum}">
                            <li><a href="?pageNum=${pageNum}">${pageNum}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="?pageNum=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="?pageNum=${pageInfo.pages}">尾页</a></li>
                </ul>
            </nav>
        </div>
    </div>

</div>
    <script>
        $("#addImg").mouseover(function () {
            $(this).css("cursor", "pointer");
        });
        $("#addImg").click(function () {
            $("#addImgModal").modal({
                backdrop:"static"
            });
        });
    </script>

<%@ include file="include/footer.jsp" %>
</body>
</html>
