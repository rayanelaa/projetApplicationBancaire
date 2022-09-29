<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<meta charset="UTF-8">
<title>details client</title>
</head>
<body>
<%@ include file = "layout/navbar.jsp"%>

	<div class= "container-fluid">
   <div class="card" style="width: 18rem;margin-top: 50px;
    margin-left: 40%; background-color: aliceblue;" >
   <div class="card-body">
    <h5 class="card-title">id : ${client.getId()} </h5>
    
    <p class="card-text">Nom : ${client.getNom()}</p>
    <p class="card-text">Prénom : ${client.getPrenom()}</p>
    <p class="card-text">Date de naissance : ${client.getDateNaissance()}</p>
    <p class="card-text">Adresse : ${client.getAdresse()}</p>
    <p class="card-text">Tél : ${client.getTel()}</p>
    <p class="card-text">Mail : ${client.getMail()}</p>
    <p class="card-text">Civilité : ${client.getCivilite()}</p>
    <a href="list-DemandeDeCredit.jsp" class="btn btn-warning">demande de credits</a>
    <a href="list-compte?idclient=${client.getId()}" class="btn btn-success">compte</a>
        
  </div>
</div>
</div>
	
</body>
</html>