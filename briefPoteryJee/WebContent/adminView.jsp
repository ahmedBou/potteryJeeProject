<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	</head>
	
	<body>
		<!--Header------------------------------------------------------  -->
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="#">Sbahia</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">Ajouter</a>
		      </li>
		    </ul>
		    <form class="form-inline my-2 my-lg-0">
		      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
		      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		    </form>
		    
		    <ul class="navbar-nav ml-auto nav-flex-icons">
	    	 <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
		          aria-haspopup="true" aria-expanded="false">
		          <i class="fas fa-user"></i>
		        </a>
		        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink-333">
		          <a class="dropdown-item" href="#!">Action</a>
		          <a class="dropdown-item" href="#!">Another action</a>
		          <a class="dropdown-item" href="#!">Something else here</a>
		        </div>
		      </li>
		    </ul>
		  </div>
		</nav>
		<!--	End OF Header------------------------------------------------------  -->
		
		<form action="po" method="get">
			<div class="container">
				<div class="row justify-content-center">
						
					<c:forEach items="${LISTS_POTTERY}" var="p">
						<div class="columns" >
							<div class="card" style="width: 18rem;">
							  <img src="${p.images}" class="card-img-top" alt="...">
							  <div class="card-body">
							    
							    <span class="card-title">Nom: <b>${p.nom}</b> </span>
							    <span class="card-title">Quantit�: <b>${p.quantite}</b></span>
							    <span class="card-title">Prix: <b>${p.prix}</b></span><br>
							    
							    <span class="card-title">Prix: <b>${p.description}</b></span><br>
							    
							    						    
<%-- 							    <form action="getId.do" method="get">
							     	
							     	<button type="submit" name="id" value="${p.id}" class="btn btn-primary" value="Modify">Modify</button>
							    	<button type="submit" name="id" value="${p.id}" class="btn btn-primary" value="Delete">Delete</button> 	
							    
							    </form>
							    
			
							    
							    
							    
							<a href="delete.do?id=${p.id}" class="btn btn-primary">Delete</a> --%>
							    
							  </div>
							</div>
						</div>
					</c:forEach>
	
				</div>
			</div>
	</form>
	</body>
</html>