<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "layout/compte-navbar.jsp"%>
	<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Confirmation </h5>
    <p class="card-text">numero : ${client.getNumero()}</p>
    <p class="card-text">date: ${client.getDate()}</p>
    <p class="card-text">montant: ${client.getMontant()}</p>
    <p class="card-text">durée: ${client.getDurée()}</p>
    <p class="card-text">taux : ${client.getTaux()}</p>
    <p class="card-text">mensualité : ${client.getMensualité()}</p>
    <p class="card-text">etat : ${client.getEtat()}</p>
  
    <a href="list-DemandeDeCredit" class="btn btn-primary">Liste demande de credit</a>
  </div>
</div>
	
</body>
</html>