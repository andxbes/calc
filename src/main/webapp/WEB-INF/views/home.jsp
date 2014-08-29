<%-- 
    Document   : home
    Created on : 24.08.2014, 10:03:41
    Author     : Andr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>make a selection</title>
    </head>
    <body>
        <a><%= request.getContextPath() %></a>
        <div style=" text-align: center; padding:100px; font-size: 55px;" >
            <a href="<%= request.getContextPath() %>/calc/jsp">JSP</a>
            <b>|</b>
            <a href="<%= request.getContextPath() %>/calc/html">HTML</a>
        </div>
    </body>
</html>
