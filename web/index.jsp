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
  <a href="a/hello">helloworld</a><br>
  <a href="/a/hello/1">helloPathvar</a>
  <form action="/a/helloPost" method="post">
    <input type="submit" value="submit"/>
  </form>
  <a href="a/testRest/1">test Rest get</a><br>
  <form action="a/testRest" method="post">
    <input type="submit" value="testRest Post"/>
  </form>
  <br>
  <form action="a/testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="testRest DELETE"/>
  </form>
  <br>
  <form action="a/testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="testRest PUT"/>
  </form>
  <br>
  <a href="/a/testRequestParam?username=wangyang&age=12">testRequestParam</a><br>
  <form action="/a/testPojo">
    username: <input type="text" name="username"/><br>
    password: <input type="password" name="password"/><br>
    email:  <input type="email" name="email"/><br>
    age:   <input type="text" name="age"/><br>
    province:   <input type="text" name="address.province"/><br>
    city:   <input type="text" name="address.city"/><br>
    <input type="submit" value="submit"/>
  </form>
  <br>
  <a href="a/testServletAPI">testServletAPI</a><br>
  <a href="a/testModelAndView">testModelAndView</a><br>
  </body>
</html>
