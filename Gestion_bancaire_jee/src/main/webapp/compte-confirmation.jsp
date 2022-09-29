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
    <p class="card-text">Id : ${client.getId()}</p>
    <p class="card-text">Num: ${client.getNum()}</p>
    <p class="card-text">DateCreation: ${client.getDateCreation()}</p>
    <p class="card-text">solde: ${client.getSolde()}</p>
    <p class="card-text">type : ${client.getType()}</p>
    <p class="card-text">Taux : ${client.getTaux()}</p>
    <p class="card-text">Decouvert : ${client.getDecouvert()}</p>
  
    <a href="list-compte" class="btn btn-primary">Liste des comptes</a>
  </div>
</div>
	
</body>
</html>