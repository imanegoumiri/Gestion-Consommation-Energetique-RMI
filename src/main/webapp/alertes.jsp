<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="card card-danger">
  <div class="card-header">
    <h3 class="card-title">Alertes de consommation</h3>
  </div>
  <div class="card-body">
    <c:if test="${not empty alertes}">
      <ul class="list-group">
        <c:forEach var="alerte" items="${alertes}">
          <li class="list-group-item list-group-item-danger">
            <i class="fas fa-exclamation-triangle text-danger"></i>
            ${alerte}
          </li>
        </c:forEach>
      </ul>
    </c:if>
    <c:if test="${empty alertes}">
      <p>Aucune alerte détectée. 🌿</p>
    </c:if>
  </div>
</div>
