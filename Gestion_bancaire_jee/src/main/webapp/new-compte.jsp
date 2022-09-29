<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Nouveau compte </title>
</head>
<body>
<%@ include file = "layout/compte-navbar.jsp"%>
<div class="container">
<h2>Nouveau compte</h2>

<form method = "post" action = "save-compte" >
	<div class = "d-flex justify-content-center  flex-column col-12">
	  <div class="form-group row mb-3 col-sm-6">
	    <label class="col-sm-4 col-form-label">num: </label>
	    <div class="col-sm-8">
	      <input type="text" class="form-control" name="num">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">solde : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="solde">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">date de Creation : </label>
	    <div class="col-sm-4">
	      <input type="date" class="form-control" name="dateCreation">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">type : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="type">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Taux : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="taux">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">decouvert : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="decouvert">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">idclient : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="idclient">
	    </div>
	  </div>
	  
	  
	 
	  <button type="submit" class="btn btn-primary mb-2">Enregistrer</button>
	  </div>
	</form>

</div>
</body>
</html>