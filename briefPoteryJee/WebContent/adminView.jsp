<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<style>
		.card>img{
			height:300px;
		}
	</style>
	
	</head>
	
	<body>
	<%@include file="header.jsp" %> 
		
		
	
			<div class="container">
				<div class="row justify-content-center">
		
				
					<c:forEach items="${data}" var="p" varStatus="status">
						<div class="columns" >
							<div class="card" style="width: 18rem;">
							  
							
							  
             				<img src="data:image/*;base64,${images[status.index]} ">          	
                
							  
							  <div class="card-body">
							    
							    <span class="card-title">Nom: <b>${p.nom}</b> </span>
							    <span class="card-title">Quantit�: <b>${p.quantite}</b></span>
							    <span class="card-title">Prix: <b>${p.prix}</b></span><br>
							    <span class="card-title">description: <b>${p.description}</b></span><br>
							    <span class="card-title"><a onclick="return confirm('Etes vous sure de supprimer le prduit?!')" href="delete.do?id=${p.id}">delete</a></b></span><br>
							    <span class="card-title"><a href="editPr.do?id=${p.id}">update</a></b></span><br>
							   

							  </div>
							</div>
						</div>
					</c:forEach>
		
	
				</div>
			
			</div>

	</body>
</html>