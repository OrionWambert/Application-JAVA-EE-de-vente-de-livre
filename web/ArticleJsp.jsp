<%-- 
    Document   : ArticleJsp
    Created on : 31 oct. 2017, 11:42:16
    Author     : Orion WAMBERT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <jsp:include page="style2.jsp" />

    <body>

        <header class="container-fluid">

            <div class="pull-left">Profile</div>

        </header>
        <br><br><br>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 box">
                    <h2>Publier un Livre</h2>

                    <form method="POST" action="<c:url value="/article"/>"    >
                        <div class="form-group">
                            <label>Titre</label>
                            <input type="text" name="nom" class="form-control"/>

                        </div>


                        <div class="form-group">
                            <label>Date d'edition</label>
                            <input type="date" name="date" class="form-control"/>

                        </div>
                        <div class="form-group">
                            <label>Auteur</label>
                            <input type="text" name="auteur" class="form-control"/>

                        </div>


                        <div class="form-group">
                            <label>Nombre de pages</label>
                            <input type="number" name="nombrePage" class="form-control"/>

                        </div>


                        <div class="form-group">
                            <label>Editeur</label>
                            <input type="text" name="editeur" class="form-control"/>

                        </div>

                        <button type="submit" name="envoyer" class="btn btn-default">envoyer</button>
                        <a href="<c:url value="/discovery"/>" class="btn btn-link">Discovery</a>
                    </form>
                </div>



                <div class="col-lg-5 col-md-5 pull-right">

                    <div class="panel-group">
                        <div class="panel panel-primary">
                            <div class="panel-heading "><h4>INFORMATION SUR L'UTILISATEUR</h4></div>
                            <div class="panel-body size">
                                Nom :<strong>${user.nom}</strong><br>
                                Prenom:<strong>${user.prenom}</strong><br>
                                Genre :<strong>${user.genre=="M"?"Masculin":"feminin"}</strong><br>
                                Login :<strong>${user.login}</strong>
                            </div>
                        </div>







                    </div>

                </div>

            </div>

            <div class="row">
                <div class="col-lg-5 col-md-5 pull-right">
                    <table class="table table-bordered table-striped table-condensed">
                        <thead>
                        <th>N°</th>
                        <th>Nom</th>
                        <th>dateEdition</th>
                        <th>Auteur</th>
                        <th>nombrePage</th>
                        <th>editeur</th>

                        </thead>
                        <tbody>

                            <c:forEach items="${livreList}" var="u"  varStatus="i">
                                <tr>

                                    <td>${i.index+1}</td>
                                    <td>${u.nom}</td>
                                    <td>${u.dateEdition}</td>
                                    <td>${u.auteur}</td>
                                    <td>${u.nombrePage}</td>
                                    <td>${u.editeur}</td>

                                    <td><form method="POST" action="<c:url value="/article"/>">

                                            <input type="hidden" value="${i.index}" name="item">
                                            <button type="submit" name="envoyer" value="remove" class="btn btn-danger">remove</button></form></td>

                                </tr>                                                      
                            </c:forEach>


                        </tbody>
                    </table>
                </div>
            </div>
        </div>





    </body>

    <jsp:include page="/style.jsp" />

</html>
