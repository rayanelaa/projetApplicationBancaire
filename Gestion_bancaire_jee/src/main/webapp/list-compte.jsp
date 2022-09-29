<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>liste-compte</title>
</head>
<body>
<%@ include file = "layout/compte-navbar.jsp"%>
<div class="container">
	<h2>liste des comptes</h2>
	
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
		      	<th>num</th>
				<th>datecreation</th>
				<th>solde</th>
				<th>type</th>
				<th>taux</th>
				<th>decouvert</th>
				<th>id client</th>
				<th></th>
				<th></th>
				
			    </tr>
			  </thead>
			  
			  <tbody>
			    
		    
		    
				<c:forEach var = "c" items="${comptes}">
				  		<tr>
					      <th scope="row">${c.getNum() }</th>
					      
					      <td>${c.getDateCreation() }</td>
					      <td>${c.getSolde() }</td>
					      <td>${c.getType() }</td>
					      <td>${c.getTaux() }</td>
					      <td>${c.getDecouvert() }</td>
					      <td>${c.getClient() }</td>
					      <td><a href="delete-compte?idclient=${c.getNum() }">Supprimer</a></td>
					       <td><a href="compte-details?idclient=${c.getNum() }">home</a></td>
					      
					    </tr>
				  		</c:forEach>
		    
		  </tbody>
		</table>
</div>
</body>
</html>