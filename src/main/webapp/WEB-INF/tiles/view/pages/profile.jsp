<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
    <style>
        th{
            text-align: center;
        }
        .container{
            margin-top: 30px;
        }
        .card{

            /*box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);*/
        }
    </style>
</head>

<body>



<div class="container">
    <div class="card" >
        <div class="card-header">
            Create Profile
        </div>
        <ul class="list-group list-group-flush">
            <br/>

           <div class="col-12">
               <form>
                   <div class="form-group row">
                       <label  class="col-sm-2 col-form-label">First Name</label>
                       <div class="col-sm-4">
                           <input type="text" class="form-control" id="inputFilstName">
                       </div>
                   </div>
                   <div class="form-group row">
                       <label class="col-sm-2 col-form-label">Last Name</label>
                       <div class="col-sm-4">
                           <input type="text" class="form-control" id="inputLastName">
                       </div>
                   </div>
                   <div class="form-group row">
                       <label class="col-sm-2 col-form-label">Profession</label>
                       <div class="col-sm-4">
                           <input type="text" class="form-control" id="inputProfession">
                       </div>
                   </div>
                   <div class="form-group row">
                       <label class="col-sm-2 col-form-label">Position Name</label>
                       <div class="col-sm-4">
                           <input type="text" class="form-control" id="inputPositionName">
                       </div>
                   </div>
                   <div class="form-group row">
                       <label class="col-sm-2 col-form-label">Address</label>
                       <div class="col-sm-4">
                           <input type="text" class="form-control" id="inputAddress">
                       </div>
                   </div>
                   <div class="form-group row">
                       <label class="col-sm-2 col-form-label">Age</label>
                       <div class="col-sm-4">
                           <input type="text" class="form-control" id="inputAge">
                       </div>
                   </div>
               </form>
           </div>

        </ul>
    </div>
</div>


    <script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
        document.getElementsByClassName("main").style.marginLeft = "250px";
        document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
    }

    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
        document.getElementsByClassName("main").style.marginLeft= "0";
        document.body.style.backgroundColor = "white";
    }
</script>
</body>

</html>
