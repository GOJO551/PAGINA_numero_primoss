<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ITQ-ADMIN
  Date: 28/11/2024
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Numeros primos resultados</title>
</head>
<body>
<h1>Resultados de los numeros Primos Encontrados</h1>

<p>Rango: <%= request.getAttribute("inicio") %> - <%= request.getAttribute("fin") %></p>
<p>Números primos encontrados:</p>

<%-- Calcula en una lista los numeros primos encontrados con utilizacion de los string--%>
<ul>
    <%
        List<Integer> primos = (List<Integer>) request.getAttribute("primos");

        for (Integer primo : primos) {
    %>
    <li><%= primo %></li>
    <% } %>

</ul>
<p>Total de números primos: <%= request.getAttribute("cantidadPrimos") %></p>
</body>
</html>
