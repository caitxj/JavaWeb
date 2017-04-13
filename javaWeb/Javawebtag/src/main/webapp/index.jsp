<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: caitxj
  Date: 4/11/2017
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<h1>jstl-core</h1>
<h2>变量</h2>
<ul>
    <li><c:set var="test" value="test"/> </li>
    <li>${test}</li>
    <li><c:remove var="test"/> |${test}</li>
</ul>
<h2>流程标签</h2>
<c:if test="true">
 1==1
</c:if>

<c:choose>
   <c:when test="${1==1}">
       when
   </c:when>
    <c:otherwise>
        other
    </c:otherwise>
</c:choose>
<%
    String[] ar={"test","test1","test2"};
    request.setAttribute("arr",ar);
%>
<c:forEach items="${arr}" var="it">
    <li>${it}</li>
</c:forEach>
<c:forTokens items="1,2,3,4,5" delims="," var="its">
    <li>${its}</li>
</c:forTokens>
<li>url</li>
<c:url var="url" value="index.jsp">
    <c:param name="test" value="a"/>
    <c:param name="name" value="b"/>
</c:url>
<a href="${url}">${url}</a>
<c:out value="test"/>


<h2>internationation</h2>
<%--setLocale:<fmt:setLocale value="ISO-3166" scope="request"/>--%>
<%--<%=request.getCharacterEncoding()%>--%>
<%--设置资源--%>
<%--<fmt:setBundle basename="in" var="inb"/>--%>
<%--testValue:<fmt:message var="test" key="test" bundle="${inb}"/>--%>
<%--format--%>
<fmt:formatNumber value="111111.1" type="currency"/>
<fmt:parseNumber value="22-2abc" type="number"/>
<fmt:parseDate value="2011-11-21"  var="md" />
<h6>${md.getHours()}</h6>
<fmt:formatDate value="<%=new Date()%>" pattern="yyyyMMdd"/>
<hr>
<h1>SQL 操作相关</h1>
<%--
1.设置数据源
2.进行查询使用
--%>
<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/test" user="root" password="root"/>
<sql:query var="queryUser" sql="SELECT * from user" dataSource="${ds}">
</sql:query>
<c:forEach items="${queryUser.rowsByIndex}" var="qu">
    <li>${qu[1]}</li>
</c:forEach>


<h1>函数操作相关</h1>
<%
    String[] arr={"test","t","t2"};
    request.setAttribute("test",arr);
%>
<li>arrLength:${fn:length(arr)}</li>
<li>upper:${fn:toUpperCase(arr[0])}</li>
<li>${fn:join(arr,"-")}</li>
</body>
</html>
