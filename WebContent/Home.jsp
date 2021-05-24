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
.jumbotron {
    padding: 2rem 1rem;
    margin-bottom: 2rem;
    background-color: #146b19d4;
    border-radius: .3rem;
    }
    .btn-primary {
    color: #fff;
    background-color: #202021;
    border-color: #007bff;
    }
</style>
<title>Home Page</title>
<% response.setHeader("Cache-Control","no-cache, no-store,must-revalidate");%>
  </head>
  <body>
    
    
    <!-- Nav Bar -->
    
    
    <nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">GROCERY MANAGMENT SYSTEM</a>
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
    <a href="login.jsp" class="nav-link">
    <i class="fa fa-user"></i>LOGIN
    </a>
    </li>
    <li class="nav-item">
    <a href="registration.jsp" class="nav-link">
    <i class="fa fa-user"></i>SIGN UP
    </a>
    </li>
    
    </ul>
  </div>
</nav>
<h1>METRO CASH & CARRY</h1>


 <div class="container-fluid">
  <div class="jumbotron">
  
  <p class="lead"><b>METRO Cash & Carry</b> is a German multinational whole chain,owned by<font color="white"><b> Metro AG </b></font>,which operates membership-only <font color="white"><b>warehouse clubs</b></font> across Europe,China,Japan,Pakistan.</p>
  <hr class="my-4">
  <br>
  <p>The cash-and-carry concept is based around self-service and bulk buying grocery targets business owners.Core customer groups are hotels,restaurants,caters,traders,and other business professionals.</p>
  <a class="btn btn-primary btn-lg" href="https://www.metro.co.in/" role="button">Learn more</a>
</div>

</div>

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