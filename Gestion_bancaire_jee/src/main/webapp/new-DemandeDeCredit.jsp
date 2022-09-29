<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Nouvelle demande de credit </title>
</head>
<body>
<%@ include file = "layout/DemandeDeCredit-navbar.jsp"%>
<div class="container">
<br>
<h2 >Nouvelle demande de credit</h2>
<br>
<form method = "post" action = "save-DemandeDeCredit" >
	<div class = "d-flex justify-content-center  flex-column col-12">
	  <div class="form-group row mb-3 col-sm-6">
	    <label class="col-sm-4 col-form-label">numero: </label>
	    <div class="col-sm-8">
	      <input type="text" class="form-control" name="numero">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">montant : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="date">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">date : </label>
	    <div class="col-sm-4">
	      <input type="date" class="form-control" name="montant">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">durée : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="durée">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Taux : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="taux">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">mensualité : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="mensualité">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">etat : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="etat">
	    </div>
	  </div>
	  
	  
	 
	  <button type="submit" class="btn btn-primary mb-2">Enregistrer</button>
	  </div>
	</form>

</div>
</body>
</html>