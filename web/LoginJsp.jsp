
<%-- 
    Document   : ArticleJsp
    Created on : 31 oct. 2017, 11:42:16
    Author     : Orion WAMBERT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <title>JSP Page</title>

    </head>
    <jsp:include page="style2.jsp" />

    <body>

        <header class="container-fluid">

            <div class="pull-left">Connexion</div>

        </header>
        <br><br><br>

        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 box">

                    <form method="POST" action="<c:url value="/login"/>" >
                        <div class="form-group">
                            <label>Login</label>
                            <input type="text" name="login" class="form-control ">

                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="mdp" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-primary" name="btn" value="1">envoyer</button>
                    </form>
                </div>

                <div>
                    <div class="col-lg-6 col-md-6 top_div_login">
                        ${message!=null?message:""}
                    </div>
                </div>
            </div>
        </div>

    </body>
    <jsp:include page="/style.jsp" />
</html>
