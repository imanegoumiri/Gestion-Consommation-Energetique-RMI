<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
  .graph-card {
    min-height: 400px;
  }

  .card-body canvas {
    width: 100% !important;
    height: 300px !important;
  }
</style>

<!-- GRAPHIQUES -->
<div class="row">
  <div class="col-md-6">
    <div class="card card-info graph-card">
      <div class="card-header"><h3 class="card-title">💡 Dernières 12 consommations</h3></div>
      <div class="card-body"><canvas id="chart1"></canvas></div>
    </div>
  </div>

  <div class="col-md-6">
    <div class="card card-success graph-card">
      <div class="card-header"><h3 class="card-title">📅 Moyenne par jour</h3></div>
      <div class="card-body"><canvas id="chart2"></canvas></div>
    </div>
  </div>

  <div class="col-md-6">
    <div class="card card-warning graph-card">
      <div class="card-header"><h3 class="card-title">🔥 Pic max quotidien</h3></div>
      <div class="card-body"><canvas id="chart3"></canvas></div>
    </div>
  </div>

  <div class="col-md-6">
    <div class="card card-danger graph-card">
      <div class="card-header"><h3 class="card-title">🌙 Répartition Jour/Nuit</h3></div>
      <div class="card-body"><canvas id="chart4"></canvas></div>
    </div>
  </div>
</div>

<!-- Chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
  new Chart(document.getElementById('chart1'), {
    type: 'line',
    data: {
      labels: [<c:forEach var="l" items="${labels}">"${l}",</c:forEach>],
      datasets: [{
        label: 'kW consommés',
        data: [<c:forEach var="d" items="${graphData}">${d},</c:forEach>],
        borderColor: '#007bff', fill: true, tension: 0.4
      }]
    }
  });

  new Chart(document.getElementById('chart2'), {
    type: 'bar',
    data: {
      labels: [<c:forEach var="d" items="${moyennesLabels}">"${d}",</c:forEach>],
      datasets: [{
        label: 'Moyenne (kW)',
        data: [<c:forEach var="v" items="${moyennesValues}">${v},</c:forEach>],
        backgroundColor: '#28a745'
      }]
    }
  });

  new Chart(document.getElementById('chart3'), {
    type: 'bar',
    data: {
      labels: [<c:forEach var="d" items="${maxLabels}">"${d}",</c:forEach>],
      datasets: [{
        label: 'Max conso',
        data: [<c:forEach var="v" items="${maxValues}">${v},</c:forEach>],
        backgroundColor: '#ffc107'
      }]
    }
  });

  new Chart(document.getElementById('chart4'), {
    type: 'doughnut',
    data: {
      labels: ['Jour', 'Nuit'],
      datasets: [{
        data: [${jour}, ${nuit}],
        backgroundColor: ['#007bff', '#6c757d']
      }]
    }
  });
</script>
