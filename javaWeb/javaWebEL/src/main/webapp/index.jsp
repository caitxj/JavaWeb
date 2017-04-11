<%@ page import="com.caitxj.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: caitxj
  Date: 4/10/2017
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>El for   简单四则运算</h1>

<ul>
    <li>${1+1}</li>
    <li>${2/4}</li>
    <li>${2-5}</li>
    <li>${4*8}</li>
    <li>${(1+8)*(5/2)}</li>
</ul>


<hr>
<h1>EL for 基本对象调用</h1>
<%
    request.setAttribute("name","mj");
    User user=new User();
    user.setId(1001);
    user.setName("testmj");
    user.age=20;
    request.setAttribute("user",user);
%>
<ul>
    <li>${name}</li>
    <li>${user.id}|${user.name}</li>
    <%--
    EL 表达式获取元素属性值时:此时属性必须存在getter 方法进行获取操作
    --%>
    <%--<li>获取没有getter方法的属性值:${user.age}</li>--%>
</ul>
<hr>
<h1>EL for  servlet  对象调用相关</h1>
<%
    request.getSession().setAttribute("userS","us");
    application.setAttribute("user","application");
%>
<ul>
    <li>${pageContext.request.contextPath}</li>
    <li>${requestScope.size()}</li>
    <li>${sessionScope.userS}</li>
    <li>${applicationScope.user}</li>
    <li>${user}</li>
</ul>
<hr>
<h1>测试集合相关</h1>
<%
    String[] data={"1","2","3"};
    List<String> lst=new ArrayList<String>();
    lst.add("test");
    lst.add("test1");
    lst.add("test2");
    Map<String,String> map=new HashMap<String, String>();
    map.put("id","1001");
    map.put("test","test");
    map.put("1001","test001");
    request.setAttribute("arr",data);
    request.setAttribute("lst",lst);
    request.setAttribute("map",map);
%>
<ul>
    <li>${arr[1]}</li>
    <li>${lst[1]}</li>
    <li>${lst.get(2)}</li>
    <li>${map.id}|${map.test}|${map["1001"]}</li>
</ul>
<hr>
<h1>方法调用相关</h1>
<%
    String test="test";
    request.setAttribute("test","test");
%>
<ul>
    <li>${test.toUpperCase()}</li>
    <li>${requestScope.user.intro()}</li>
    <li>${requestScope.user.setId(1991)}|${requestScope.user.id}</li>
</ul>
<script src="testEl.js"></script>
<script type="text/javascript">
    var name="${name}";
//    sayName(name);
</script>
</body>
</html>
