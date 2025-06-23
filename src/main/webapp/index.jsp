
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Accueil - Gestion Énergie</title>
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <span class="navbar-brand">Gestion de consommation énergitique</span>
  </nav>

  <!-- Sidebar -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <a href="#" class="brand-link">
      <span class="brand-text font-weight-light">Dashboard</span>
    </a>
    <div class="sidebar">
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" role="menu">
          <li class="nav-item">
            <a href="adminlte/pages/acceuil.html" class="nav-link active">
              <i class="nav-icon fas fa-home"></i>
              <p>Accueil</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="adminlte/pages/charts/chartjs.html" class="nav-link">
              <i class="nav-icon fas fa-chart-line"></i>
              <p>Analyse</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="adminlte/pages/forms/general.html" class="nav-link">
              <i class="nav-icon fas fa-cogs"></i>
              <p>Gestion Appareils</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="adminlte/pages/alertes.html" class="nav-link">
              <i class="nav-icon fas fa-exclamation-triangle"></i>
              <p>Alertes</p>
            </a>
          </li>
        </ul>
      </nav>
    </div>
  </aside>

  <!-- Content -->
  <div class="content-wrapper p-4">
    <section class="content">
      <div class="container-fluid">
        <h2>Bienvenue dans le système de gestion énergétique</h2>
        <p>Suivez, analysez et optimisez la consommation électrique en temps réel.</p>

        <div class="row">
          <div class="col-md-4">
            <div class="small-box bg-success">
              <div class="inner">
                <h3>245 kWh</h3>
                <p>Consommation Totale</p>
              </div>
              <div class="icon">
                <i class="fas fa-battery-three-quarters"></i>
              </div>
              <a href="adminlte/pages/charts/chartjs.html" class="small-box-footer">Voir Détails <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>

          <div class="col-md-4">
            <div class="small-box bg-warning">
              <div class="inner">
                <h3>8</h3>
                <p>Appareils actifs</p>
              </div>
              <div class="icon">
                <i class="fas fa-plug"></i>
              </div>
              <a href="adminlte/pages/forms/general.html" class="small-box-footer">Gérer Appareils <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>

          <div class="col-md-4">
            <div class="small-box bg-danger">
              <div class="inner">
                <h3>2</h3>
                <p>Alertes critiques</p>
              </div>
              <div class="icon">
                <i class="fas fa-exclamation-triangle"></i>
              </div>
              <a href="adminlte/pages/alertes.html" class="small-box-footer">Voir Alertes <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
        </div>

      </div>
    </section>
  </div>

</div>

<script src="plugins/jquery/jquery.min.js"></script>
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="dist/js/adminlte.min.js"></script>
</body>
</html>

