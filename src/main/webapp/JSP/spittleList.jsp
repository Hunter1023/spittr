<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
    <%@ include file="include/head.jsp"%>
    <body>
        <div id="content">
            <div class="publish">
                <%--当前未提供图片发布功能--%>
                <sf:form class="m-form m-form-ht n-login" id="loginForm"
                    method="post" modelAttribute="spittle" >
                    <div class="fmitem">
                        <div class="fmipt">
                            <!-- sf:input渲染成的html的type=text ,path属性值会渲染成value值 -->
                            <sf:textarea path="message" cols="80" rows="4" />
                            <sf:errors path="message"/>
                        </div>
                    </div>
                    <div class="fmitem fmitem-nolab fmitem-btn">
                        <div class="fmipt">
                            <input type="submit"
                                   class="u-btn u-btn-primary u-btn-lg u-btn-block" value="发布"/>
                        </div>
                    </div>
                </sf:form>

            </div>
            <div class="n-plist">
                <h2>动态列表</h2>
                <ul class="f-cb" id="plist">
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
                </ul>
            </div>

        </div>

        <%@ include file="include/footer.jsp"%>
    </body>
</html>
