<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recommandations énergétiques</title>
    <link rel="stylesheet" href="adminlte/css/adminlte.min.css">
    <link rel="stylesheet" href="adminlte/plugins/fontawesome-free/css/all.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

    <!-- Barre de navigation -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="Dashboard.jsp" class="nav-link">🏠 Tableau de bord</a>
            </li>
            <li class="nav-item">
                <a href="alertes.jsp" class="nav-link">🚨 Alertes</a>
            </li>
            <li class="nav-item">
                <a href="recommandations.jsp" class="nav-link active">💡 Recommandations</a>
            </li>
        </ul>
    </nav>

    <!-- Contenu principal -->
    <div class="content-wrapper p-4">
        <h2>🔍 Conseils personnalisés</h2>

        <form action="RecommandationServlet" method="post" class="mb-4">
            <div class="form-group">
                <label for="appareil">Nom de l'appareil :</label>
                <input type="text" name="appareil" id="appareil" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Générer les conseils</button>
        </form>

        <%
            List<String> conseils = (List<String>) request.getAttribute("conseils");
            if (conseils != null && !conseils.isEmpty()) {
        %>
        <div class="card">
            <div class="card-header bg-success text-white">💬 Résultats</div>
            <div class="card-body">
                <ul class="list-group">
                    <% for (String c : conseils) { %>
                        <li class="list-group-item"><%= c %></li>
                    <% } %>
                </ul>
            </div>
        </div>
        <% } else if (request.getParameter("appareil") != null) { %>
            <div class="alert alert-warning mt-3">Aucun conseil trouvé pour cet appareil.</div>
        <% } %>
    </div>

</div>

<script src="adminlte/plugins/jquery/jquery.min.js"></script>
<script src="adminlte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="adminlte/js/adminlte.min.js"></script>
</body>
</html>
