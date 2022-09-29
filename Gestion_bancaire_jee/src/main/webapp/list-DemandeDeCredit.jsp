<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>liste-DemandeDeCredit</title>
</head>
<body>
<%@ include file = "layout/DemandeDeCredit-navbar.jsp"%>
<div class="container">
	<h2>liste demande de credit</h2>
	
		<form method = "post" action="find">
	 <div class="form-group row mb-3">
	    
	    <div class="col-sm-3">
	      <input type="text" class="form-control" name="nom" placeholder="Nom">
	    </div>
	    
	    <div class="col-sm-3">
	      <input type="text" class="form-control" name="prenom" placeholder="Prénom">
	    </div>
	    
	    <button type="submit" class="btn btn-primary col-sm-2 mb-2">Chercher</button>
	  </div>
	  
	 </form>
	 
<table class="table">
		  <thead>
		    <tr>
		      	<th>numero</th>
				<th>date</th>
				<th>montant</th>
				<th>durée</th>
				<th>taux</th>
				<th>mensualité</th>
				<th>etat</th>
				<th></th>
				<th></th>
				
			    </tr>
			  </thead>
			  
			  <tbody>
			    
		    
		    
				<c:forEach var = "c" items="${DeamndeDeCredit}">
				  		<tr>
					      <th scope="row">${c.getNumero() }</th>
					      
					      <td>${c.getDat() }</td>
					      <td>${c.getMontant() }</td>
					      <td>${c.getDurée() }</td>
					      <td>${c.getTaux() }</td>
					      <td>${c.getMensualité() }</td>
					      <td>${c.getEtat() }</td>
					      <td><a href="delete-DemandeDeCredit?idclient=${c.getNum() }">Supprimer</a></td>
					        <td><a href="compte-detail?idclient=${c.getNum() }">modifier</a></td>
					      
					    </tr>
				  		</c:forEach>
				  		
				  		
		    
		  </tbody>
		</table>
		<a href="new-DemandeDeCredit.jsp" class="btn btn-info" role="button">nouvelle demande</a>
</div>
</body>
</html>