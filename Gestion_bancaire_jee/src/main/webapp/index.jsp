 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<meta charset="UTF-8">
		<title>gestion bancaire</title>
	</head>
	
	<body style="background-color: antiquewhite;">
	<%@ include file = "layout/navbar.jsp" %>
	
		
		<nav>
		 
		</nav>
		
		<section>
	<br>
		<div class="row container_display" style="margin-bottom: 50px;
          margin-top: 50px;">
	  	<div class="col-sm-12 card_display">
	    <div class="card" style="background-color: #F1948A; margin-left: 40%;
    margin-right: 40%;" >
	      <div class="card-body text-center">
	       <h5 class="card-title">Liste des Clients</h5>
	        <a href="list-client" class="btn button_display " style="background-color: #ECF0F1;">Cliquer Ici</a>
	        
			
			
			</div>
	    </div>
	  </div>
	  </div>
	  
	    <div class="col-sm-12 card_display" style="margin-bottom: 50px;
          margin-top: 50px;">
	    <div class="card" style="background-color: #F1948A; margin-left: 40%;
    margin-right: 40%; ">
	      <div class="card-body text-center">
	        <h5 class="card-title">Ajouter un Nouveau Client</h5>
	        <a href="new-client" class="btn button_display" style="background-color: #ECF0F1;">Cliquer Ici</a>
	       
	      </div>
	    </div>
	  </div>

	
	
	

		</section>
			
			<%@ include file = "layout/footer.jsp" %>
		
	</body>
</html>