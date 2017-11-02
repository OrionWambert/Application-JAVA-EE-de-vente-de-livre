<%-- 
    Document   : RegisterJsp
    Created on : 31 oct. 2017, 11:41:53
    Author     : Orion WAMBERT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Inscription</title>


    </head>
    <jsp:include page="style2.jsp" />

    <body>

        <header class="container-fluid">

            <div class="pull-left">Inscription</div>

        </header>
        <br><br><br>
        <div class="container">
            <div class="row">
                <div class=" col-lg-6 col-md-6 box">

                    <form method="POST" action="<c:url value="/" />"                       >
                        <div class="form-group">
                            <label>Nom</label>
                            <input type="text" name="nom" class="form-control" />

                        </div>
                        <div class="form-group">
                            <label>Prenom</label>
                            <input type="text" name="prenom" class="form-control" />
                        </div>
                        <div class="form-group" >
                            <label>Genre</label><br>
                            <label>M   </label><input style="margin-left: 2%;"  type="radio" value="M" name="genre"  />
                            <label  class="pos2" >F  </label><input style="margin-left: 2%;"  type="radio" value="F" name="genre"  />

                        </div>

                        <div class="form-group">
                            <label>Login</label>
                            <input type="text" name="login" class="form-control" />

                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="mdp" class="form-control" >
                        </div>
                        <button type="submit" name="btn1" value="1" class="btn btn-success">Valider</button>
                        <button type="submit" name="btn1" value="2" class="btn btn-primary">Connexion</button>




                </div><br>
                <div class="col-lg-6 col-md-6 top_div_register">
                    ${message!=null?message:""}
                </div>

            </div>


        </div>

    </body>

    <jsp:include page="/style.jsp" />

</html>




