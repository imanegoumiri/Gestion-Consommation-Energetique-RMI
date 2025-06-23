<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<h2>🔍 Recommandations pour la maison</h2>

<%
    List<String> conseils = (List<String>) request.getAttribute("conseils");
    if (conseils != null && !conseils.isEmpty()) {
%>
<div class="card">
    <div class="card-header bg-success text-white">💬 Conseils générés</div>
    <div class="card-body">
        <ul class="list-group">
            <% for (String c : conseils) { %>
                <li class="list-group-item"><%= c %></li>
            <% } %>
        </ul>
    </div>
</div>
<% } else { %>
    <div class="alert alert-warning mt-3">Aucun conseil trouvé pour l'appareil "maison".</div>
<% } %>