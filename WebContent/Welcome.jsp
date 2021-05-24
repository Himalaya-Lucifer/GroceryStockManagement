<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
   
    <style>
    table 
    {
      width:100%;
      border:0.5px solid black;
    }
    tr:nth-child(even)
    {
       background-color: #f2f2f2
    }
    
    .bg-warning {
    background-color: #0c4b8e!important;
    }
    .btn-primary {
    color: #fff;
    background-color: #264c1e;
    border-color: #121313;}
    </style>
    <title>LIST PAGE</title>
    <% response.setHeader("Cache-Control","no-cache, no-store,must-revalidate");%>
  </head>
  <body>
    
    
    <!-- Nav Bar -->
    
    
    <nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">GROCERY STOCK MANAGMENT</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="https://www.metro.co.in/about-us">About Us</a>
      </li>
      
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Contact Us</a>
      </li>

    </ul>
    
    <ul class="navbar-nav mi auto">
    
    
    
    <li class="nav-item">
    <a href="#" data-toggle="modal" data-target="#addPostModal">
    <i class="fa fa-user"></i><img src="data:image/jpg;base64,${user.base64Image}" class="rounded-circle" width="40" height="40"/>
    </a>
    </li>
    
    
    <li class="nav-item">
    <a href="#" class="nav-link">
    <i class="fa fa-user"></i>WELCOME ${user.firstName} 
    </a>
    </li>
    </a>
    </li>
    <li class="nav-item">
    <a href="UserController?command=LOGOUT" class="nav-link">
    <i class="fa fa-user"></i>LOGOUT
    </a>
    </li>
    </a>
    </li>
    
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown">Service</a>
      <div class="dropdown-menu" arial-labelledby="navbarDropdown">
      <a class="dropdown-item" href="#">TU</a>
      </div>
      </li>
    
    </ul>
  </div>
</nav>
<div class="container-fluid ">
<header id="main-header" class="py-2 bg-warning text-white">
    <div class="container-fluid">
      <div class="row">
        <div class="col-xl">
        <image src="homepage.jpg" class="rounded float-left" height="100" width="150">
        <br>
        <h1 style="font-size:50px" align="center">GROCERY DETAILS</h1>
        </div>
      </div>
    </div>
  </header>
  </div>
  
  <br>
<div class="container-fluid mt-3 mb-3">
  
 
	<form action="add_item.jsp">
	<button type="submit" class="btn btn-primary">Add Item</button>
	</form>
	<br>
	<form class="form-inline my-2 my-lg-0" action="ItemController">
	 <input type="hidden" name="command" value="SEARCH"/>
      <input class="form-control mr-sm-2" type="search" name="searchName" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <h4 style="color: white;">${msg}</h4>
	</div>
	
	<div class="container-fluid">
<table class="table">
<thead class="thead-dark">
				<tr>
					<th><i>Item Name</i></th>
					<th>Unit</th>
					<th>Quantity On Hand</th>
					<th>Price Per Unit</th>
					<th>Date Of Expiry</th>
					<th>Location</th>
					<th>Action</th>
					</tr>
					</thead>
    <tbody>
			 <c:forEach var="item" items="${item_list}">
			 <c:url var="updateLink" value="ItemController">
			 <c:param name="command" value="LOAD"/>
			 <c:param name="itemCode" value="${item.itemCode }"/>
			 </c:url>
			 <c:url var="deleteLink" value="ItemController">
			 <c:param name="command" value="DELETE"/>
			 <c:param name="itemCode" value="${item.itemCode }"/>
						 
			  </c:url>
			   
					<tr>
					<td>${item.itemName }</td>
					<td>${item.unit }</td>
					<td>${item.quantityOnHand }</td>
					<td>${item.pricePerUnit }</td>
					<td>${item.dateOfExpiry }</td>
					<td>${item.location }</td>
					<td><a href="${updateLink}"><font color="SlateBlue"><b>Update</b></font></a>
					<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this item'))) return false"><font color="SlateBlue"><b> | Delete</b></font></a></td>
					</tr>

				</c:forEach>
				</tbody>
			</table>
			</div>
    
    
     <!-- POST MODAL -->
			
  <div class="modal fade" id="addPostModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header bg-primary text-white">
          <h5 class="modal-title">Update Photo</h5>
          <button class="close" data-dismiss="modal"><span>&times;</span></button>
        </div>
        
        <div class="modal-body">
        
          <form action="UserController" method="post" enctype="multipart/form-data">
          
         	 <input type="hidden" name="command" value="UPDATEPHOTO">
         	 <input type="hidden" name="userId" value="${user.userId}">
          
              <div class="form-group">
              <label for="file">Photo Upload</label>
              <input type="file" name="photo" class="form-control-file">
              <small class="form-text text-muted">Max Size 3mb</small>
            </div>
            
            <div class="modal-footer">
          <button class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button class="btn btn-primary" type="submit">Update Photo</button>
        </div>
            
            </form>
            
        </div>
        
        
        
        
      </div>
    </div>
  </div>
  <br>
  <!-- FOOTER -->
   <div class="container-fluid">
  <footer id="main-footer" class="bg-secondary text-white mt-5 p-5">
    <div class="container">
      <div class="row">
        <div class="col">
          <p class="lead text-center">
            Copyright &copy;
            <span id="year"></span>
            METRO-CASH-&-CARRY
          </p>
        </div>
      </div>
    </div>
  </footer>
  </div>
  
  
  
			
	 <script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
    crossorigin="anonymous"></script>
  <script src="https://cdn.ckeditor.com/4.9.2/standard/ckeditor.js"></script>	
    
    
  </body>
</html>