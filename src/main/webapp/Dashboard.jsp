<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
  <title>Dashboard - Analyse</title>
  <link rel="stylesheet" href="adminlte/dist/css/adminlte.min.css">
</head>
<body>
  <div class="container mt-4">
    <h2>📊 Historique de consommation</h2>

    <c:if test="${not empty historique}">
      <ul>
        <c:forEach var="rec" items="${historique}">
  <li>${rec.timestamp} : ${rec.consommation} kW</li>
</c:forEach>
      </ul>
    </c:if>


    <c:if test="${empty historique}">
      <p>Aucune donnée disponible</p>
    </c:if>
  </div>
</body>
</html>
