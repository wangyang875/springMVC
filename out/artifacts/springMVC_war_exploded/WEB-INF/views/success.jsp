<%--
  Created by IntelliJ IDEA.
  User: WaRRyant
  Date: 2019/1/11
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <h4>Success Page</h4>
  time: ${requestScope.time}
  <br>
  names: ${requestScope.names}
  <br>
  request user:${requestScope.user}
 <br>
 session user:${sessionScope.user}
  </body>
</html>
