<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
     html,body 
     {
  height: 100%;
  background-color: #eee;
}

body {
  display: -ms-flexbox;
  
 
  text-shadow: 0 .05rem .1rem rgba(0, 0, 0, .5);
  box-shadow: inset 0 0 5rem rgba(0, 0, 0, .5);
}
.bg-warning {
    background-color: #0c4b8e!important;
    }
    .btn-primary {
    color: #fff;
    background-color: #0b3820;
    border-color: #040404;
    }
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
       <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown">Service</a>
      <div class="dropdown-menu" arial-labelledby="navbarDropdown">
      <a class="dropdown-item" href="#">TU</a>
      </div>
      </li>

    </ul>
    
    <ul class="navbar-nav mi auto">
    
    <li class="nav-item">
    <a href="#" class="nav-link">
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
    
    </ul>
  </div>
</nav>
<div  class="container-fluid " >
<header id="main-header" class="py-2 bg-warning text-white">
    <div class="container-fluid">
      <div class="row">
        <div class="col-xl">
        <image src="homepage.jpg" class="rounded float-left" height="100" width="150" aling="middle">
        <br>
        <h1 align="center">ADD GROCERY ITEMS</h1>
        </div>
      </div>
    </div>
  </header>
  </div>
  
  <br>
  <div align="center">
  <h3>${msg}</h3>
  <br>
  <br>
</head>
<br>

	<form action="ItemController" method="post">
	<input type="hidden" name="command" value="ADD"/>
	<table>
	<tbody>
	
	<tr>
	<th>Item_Name  :</th>
	<th><input type="text" name="itemName" placeholder="itemName" required="required"/></th>
	</tr>
	
	<tr>
	<th>Unit  :</th>
	<th><input type="text" name="unit" placeholder="Unit" required="required"/></th>
	</tr>
	
	<tr>
	<th>Beginning_Inventory  :</th>
	<th><input type="number" name="beginningInventory" placeholder="BeginningInventory" required="required"/></th>
	</tr>
	
	<tr>
	<th>Quantity_On_Hand  :</th>
	<th><input type="number" name="quantityOnHand" placeholder="QuantityOnHand" required="required"/></th>
	</tr>
	
	<tr>
	<th>Price_Per_Unit   :</th>
	<th><input type="number" name="pricePerUnit" required="required" placeholder="PricePerUnit" min ="0"/></th>
	</tr>
	
	<tr>
	<th>Date_Of_Manufacture</th>
	<th><input type="Date" name="dateOfManufacture" placeholder="DateOfManufacture" required="required"/></th>
	</tr>
	
	<tr>
	<th>Date_Of_Expiry</th>
	<th><input type="Date" name="dateOfExpiry" placeholder="DateOfExpiry" required="required"/></th>
	</tr>
	
	<tr>
	<th>Location</th>
	<th><select name="location" required="required">
	<option disabled selected value="" required="required">Selected Location</option>
	<option>Bulk Zone</option>
	<option>Pick Zone</option>
	<option>Distribution Center</option>
	</select></th>
	</tr>
	<tr>
	<th>Category</th>
	<th><select name="category" required="required">
	<option disabled selected value="">Selected Category</option>
	<option>Vegetables</option>
	<option>Fruit</option>
	<option>dry fruits</option>
	<option>Dairy</option>
	</select></th>
	</tr> 
	<tr>
   <th></th>
   <th></th>
	</tr>
	<tr colspan="2">
	<th><label></label></th>
	<th><input  class="btn btn-primary" type="submit" value="Submit"/></th>
	</tr>
	</tbody>
	</table>
</form>
<div style="clear:both;"></div>
<p>
<br>
<a href="ItemController">Back To List</a>
</p>
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
  
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>